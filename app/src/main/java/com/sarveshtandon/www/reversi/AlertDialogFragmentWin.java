package com.sarveshtandon.www.reversi;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AlertDialogFragmentWin extends DialogFragment {
    public int x=-1;

    //public String message = getString(R.string.error_message) + getString(R.string.rules_link);
    public int getX() {
        return x;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Context context = getActivity();
        final TextView t= new TextView(context);
        t.setText(R.string.victory_text);
        t.setMovementMethod(LinkMovementMethod.getInstance());
        t.setTextAppearance(R.style.TextAppearance_AppCompat_Body1);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Congratulations!")
                .setMessage(R.string.victory_text)
                .setPositiveButton("OK!", null);

        return builder.create();
    }
}
