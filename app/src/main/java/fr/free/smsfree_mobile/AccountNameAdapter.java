package fr.free.smsfree_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fr.free.smsapi.NamedAccount;

public class AccountNameAdapter extends BaseAdapter {

	private final Context mContext;
	private final List<NamedAccount> mAccounts;

    AccountNameAdapter(Context context, List<NamedAccount> accounts) {
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
            convertView = new TextView(parent.getContext());
        }

        // set name
        ((TextView)convertView).setText(entry.getName());

        return convertView;
    }
}
