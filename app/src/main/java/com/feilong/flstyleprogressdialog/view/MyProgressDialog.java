package com.feilong.flstyleprogressdialog.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.feilong.flstyleprogressdialog.R;

public class MyProgressDialog extends Dialog {
    private MyProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    public static MyProgressDialog show(Context context, CharSequence message, boolean cancelable, DialogInterface.OnKeyListener keyListener) {
        MyProgressDialog dialog = new MyProgressDialog(context, R.style.dialog_progress);
        dialog.setTitle("");
        dialog.setContentView(R.layout.layout_dialog_progress);
        if (TextUtils.isEmpty(message)) {
            dialog.findViewById(R.id.message).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView) dialog.findViewById(R.id.message);
            txt.setText(message);
        }

        dialog.setCanceledOnTouchOutside(cancelable);
        dialog.setCancelable(cancelable);
        dialog.setOnKeyListener(keyListener);
        Window window = dialog.getWindow();
        if (window != null) {
            window.getAttributes().gravity = 17;
            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
            lp.dimAmount = 0.6F;
            dialog.getWindow().setAttributes(lp);
            dialog.show();
        }

        return dialog;
    }
}
