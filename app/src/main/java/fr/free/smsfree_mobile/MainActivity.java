package fr.free.smsfree_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import fr.free.smsapi.NamedAccount;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner sAccounts = findViewById(R.id.spinner);

        List<NamedAccount> accounts = AccountsHelper.getNamedAccounts(this);

        // FIXME remove
        accounts.add(new NamedAccount("Demo", "123", "pass"));

        // Create an adapter
        AccountNameAdapter adapter = new AccountNameAdapter(this, accounts);

        // Apply the adapter to the spinner
        sAccounts.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_accounts:
                Intent intent = new Intent(this, AccountsActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void clearText(View view) {
        TextView text = findViewById(R.id.editText);
        text.setText("");
    }

}
