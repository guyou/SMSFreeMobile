package fr.free.smsfree_mobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import fr.free.smsapi.Account;
import fr.free.smsapi.NamedAccount;
import fr.free.smsapi.Sender;

public class MainActivity extends AppCompatActivity implements DownloadCallback {

    // Keep a reference to the NetworkFragment which owns the AsyncTask object
    // that is used to execute network ops.
    private NetworkFragment mNetworkFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner sAccounts = findViewById(R.id.spinner);

        List<NamedAccount> accounts = AccountsHelper.getNamedAccounts(this);

        // Create an adapter
        AccountNameAdapter adapter = new AccountNameAdapter(this, accounts);

        // Apply the adapter to the spinner
        sAccounts.setAdapter(adapter);

        mNetworkFragment = NetworkFragment.getInstance(getSupportFragmentManager());
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

    public void sendText(View view) {
        Spinner sAccounts = findViewById(R.id.spinner);
        List<NamedAccount> accounts = AccountsHelper.getNamedAccounts(this);
        Account account = accounts.get(sAccounts.getSelectedItemPosition());

        TextView text = findViewById(R.id.editText);
        String msg = text.getText().toString();

        mNetworkFragment.startDownload(account, msg);
    }

    public void clearText(View view) {
        TextView text = findViewById(R.id.editText);
        text.setText("");
    }

    @Override
    public void updateFromDownload(String result) {
    // Update your UI here based on result of download.
    }

    @Override
    public NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo;
    }

    @Override
    public void onProgressUpdate(int progressCode, int percentComplete) {
        switch(progressCode) {
            // You can add UI behavior for progress updates here.
            case Progress.ERROR:
            // TODO...
                break;
            case Progress.CONNECT_SUCCESS:
            // TODO...
                break;
            case Progress.GET_INPUT_STREAM_SUCCESS:
            // TODO...
                break;
            case Progress.PROCESS_INPUT_STREAM_IN_PROGRESS:
            // TODO...
                break;
            case Progress.PROCESS_INPUT_STREAM_SUCCESS:
            // TODO...
                break;
        }

    }

    @Override
    public void finishDownloading() {
        if (mNetworkFragment != null) {
            mNetworkFragment.cancelDownload();
        }

    }
}
