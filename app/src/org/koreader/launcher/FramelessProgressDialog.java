package org.koreader.launcher;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;

import androidx.core.content.ContextCompat;

class FramelessProgressDialog extends Dialog {

    private FramelessProgressDialog(Context context) {
        super(context, R.style.FramelessDialog);
    }

    static FramelessProgressDialog show(Context context, CharSequence title) {

        FramelessProgressDialog dialog = new FramelessProgressDialog(context);
        dialog.setTitle(title);
        dialog.setCancelable(false);
        dialog.setOnCancelListener(null);
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        ProgressBar progressBar = new ProgressBar(context);
        Drawable progressDrawable = ContextCompat.getDrawable(context, R.drawable.discrete_spinner);
        progressBar.setIndeterminateDrawable(progressDrawable);

        /* The next line will add the ProgressBar to the dialog. */
        dialog.addContentView(progressBar,
                new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        dialog.show();

        return dialog;
    }
}
