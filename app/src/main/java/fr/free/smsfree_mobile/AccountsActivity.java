package fr.free.smsfree_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import fr.free.smsapi.NamedAccount;

public class AccountsActivity extends AppCompatActivity {

    private static final String TAG = "AccountsActivity";
    private ListView lvAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        List<NamedAccount> accounts = AccountsHelper.getNamedAccounts(this);

        lvAccounts = (ListView)findViewById(R.id.listAccounts);
        AccountRowAdapter adapter = new AccountRowAdapter(this, accounts);
        lvAccounts.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.accounts_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_account:
                Log.d(TAG, "Add a new account");
                AccountDialogFragment dialog = new AccountDialogFragment();
                dialog.show(getSupportFragmentManager(), "AddAccountDialog");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
