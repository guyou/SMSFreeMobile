package fr.free.smsfree_mobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.free.smsapi.NamedAccount;

public class AccountsHelper {

    @NonNull
    public static List<NamedAccount> getNamedAccounts(Context context) {
        List<NamedAccount> accounts = new ArrayList<>();
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.accounts_file_key), Context.MODE_PRIVATE);

        Map<String, ?> savedAccount = sharedPref.getAll();
        for (String name: savedAccount.keySet()) {
            String values = sharedPref.getString(name, null);
            String[] array = values.split(" ");
            String user = array[0];
            String pass = array[1];
            NamedAccount current = new NamedAccount(name, user, pass);
            accounts.add(current);
        }
        return accounts;
    }

    public static void addNamedAccount(Context context, NamedAccount account) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.accounts_file_key), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        String value = String.format("%s %s", account.getUser(), account.getPassword());
        editor.putString(account.getName(), value);
        editor.commit();


    }
}
