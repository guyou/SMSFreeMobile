package fr.free.smsfree_mobile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import fr.free.smsapi.NamedAccount;

public class AccountDialogFragment extends DialogFragment {

    private EditText etName;
    private EditText etUser;
    private EditText etPassword;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_new_account)
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // TODO
                        NamedAccount newAccount = new NamedAccount(etName.getText().toString(),
                                etUser.getText().toString(),
                                etPassword.getText().toString());
                        AccountsHelper.addNamedAccount(getActivity(), newAccount);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.account_editor, null);
        builder.setView(view);
        etName = view.findViewById(R.id.newName);
        etUser = view.findViewById(R.id.newUser);
        etPassword = view.findViewById(R.id.newPassword);

        // Create the AlertDialog object and return it
        return builder.create();
    }
}