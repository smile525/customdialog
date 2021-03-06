package com.zp.customdialoglib.dialog;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;

public interface ICommonDialog {
    // 标题部分的接口
    void setTitleText(int titleStrId);
    void setTitleText(CharSequence titleStr);
    void setTitleColorType(int titleColorType);
    void setTitleBgType(int titleBgType);
    EditText getEditText();
    EditText getEditText1();

    void setContentEd(String text);
    void setContentEd1(String text);

    // 中间内容部分接口
    void setContentText(int contentStrId);
    void setContentText(CharSequence contentStr);
    void setContentView(int contentLayoutId);
    void setContentView(View contentView);
    void setContentView(View contentView, ViewGroup.LayoutParams params);
    // 中间内容地下部分
    void setContentText2(int contentStrId);
    void setContentText2(CharSequence contentStr);
    void setContentView2(int contentLayoutId);
    void setContentView2(View contentView);
    void setContentView2(View contentView, ViewGroup.LayoutParams params);

    // 底部按钮相关接口
    void setCancelBtn(int textId, OnClickListener cancelClickListener);
    void setCancelBtn(CharSequence text, OnClickListener cancelClickListener);
    void setOkBtn(int textId, OnClickListener okClickListener);
    void setOkBtn(CharSequence text, OnClickListener okClickListener);
    void setOkBtnStyleType(int okBtnStyleType);

    // 代理Dialog的一些方法
    void setCanceledOnTouchOutside(boolean canceledOnTouchOutside);
    void setOnDismissListener(DialogInterface.OnDismissListener listener);
    void setOnShowListener(DialogInterface.OnShowListener listener);
    void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener);
    void setCancelable(boolean b);

    CoreDialog getCoreDialog();
    boolean isShow();

    void show();
    void dismiss();
    void cancel();
}