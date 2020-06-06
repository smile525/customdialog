package com.zp.customdialoglib.loading;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.zp.customdialoglib.R;


/**
 * dialog处理handle
 */
public class ProgressDialogHandler extends Handler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private Dialog pd;

    private Context context;
    private boolean cancelable;
    private IProgressCancelListener mProgressCancelListener;
    private String tvMsg;
    private final Activity mActivity;
    private TextView msg ;

    public ProgressDialogHandler(Context context,
                                 boolean cancelable) {
        super();
        this.context = context;
        this.cancelable = cancelable;
        mActivity = (Activity) this.context;
        tvMsg = context.getString(R.string.loading_progress_dialog_handler);
    }

    public ProgressDialogHandler(Context context, IProgressCancelListener mProgressCancelListener,
                                 boolean cancelable) {
        super();
        this.context = context;
        this.mProgressCancelListener = mProgressCancelListener;
        this.cancelable = cancelable;
        mActivity = (Activity) this.context;
        tvMsg = context.getString(R.string.loading_progress_dialog_handler);
    }

    public void setTvMsg(String tvMsg) {
        this.tvMsg = tvMsg;
    }

    private void initProgressDialog(){
        if (pd == null) {
            pd = new Dialog(context, R.style.progress_dialog);
            pd.setContentView(R.layout.layout_dialog);
            pd.setCancelable(true);
            pd.setCanceledOnTouchOutside(false);
            pd.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            msg = (TextView) pd.findViewById(R.id.id_tv_loadingmsg);
            pd.setCancelable(cancelable);
            msg.setText(tvMsg);
            if (cancelable) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        mProgressCancelListener.onCancelProgress();
                    }
                });
            }

            if (!pd.isShowing()&& !mActivity.isFinishing()) {
                pd.show();
            }
        } else {
            msg.setText(tvMsg);
        }
    }

    private void dismissProgressDialog(){
        if (pd != null && !mActivity.isFinishing()) {
            pd.dismiss();
            pd = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }

}
