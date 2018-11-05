package fr.free.smsfree_mobile;

import android.content.Context;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.free.smsapi.NamedAccount;

public class AccountRowAdapter extends BaseAdapter {

	private final Context mContext;
	private final List<NamedAccount> mAccounts;

    AccountRowAdapter(Context context, List<NamedAccount> accounts) {
        mContext = context;
        mAccounts = accounts;
    }


    @Override
    public int getCount() {
        return mAccounts.size();
    }

    @Override
    public Object getItem(int pos) {
        return mAccounts.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        // get selected entry
        NamedAccount entry = mAccounts.get(pos);

        // inflating list view layout if null
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.account_row, null);
        }

        // set name
        TextView tvName = (TextView)convertView.findViewById(R.id.name);
        tvName.setText(entry.getName());

        // set user
        TextView tvPhone = (TextView)convertView.findViewById(R.id.user);
        tvPhone.setText(entry.getUser());

        // set password
        TextView tvEmail = (TextView)convertView.findViewById(R.id.password);
        tvEmail.setText(entry.getPassword());

        return convertView;
    }
}
