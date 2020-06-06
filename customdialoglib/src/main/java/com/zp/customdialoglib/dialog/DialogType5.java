package com.zp.customdialoglib.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zp.customdialoglib.R;


/**
 * 类型5 Dialog
 * 有标题，输入框（手机号），2个确定按钮
 */

public class DialogType5 extends DialogBase {
    private TextView mOkTv;
    private TextView mCancelTv;
    private EditText mContentEd;

    public DialogType5(Context context) {
        super(context);
    }

    @Override
    public void initDialog() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_layout_type5, null);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mOkTv = (TextView) rootView.findViewById(R.id.common_dialog_ok_btn);
        mCancelTv = (TextView) rootView.findViewById(R.id.common_dialog_cancel_btn);
        mContentEd = (EditText) rootView.findViewById(R.id.common_dialog_edit_text);
        createDialog(rootView);
    }

    @Override
    public EditText getEditText() {
        return mContentEd;
    }

    @Override
    public void setContentEd(String text) {
        this.mContentEd.setText(text);
    }

    @Override
    public void setCancelBtn(int textId, View.OnClickListener cancelOnClickListener) {
        mCancelTv.setText(textId);
        setOnCancelClickListener(cancelOnClickListener);
    }

    @Override
    public void setCancelBtn(CharSequence text, View.OnClickListener cancelOnClickListener) {
        mCancelTv.setText(text);
        setOnCancelClickListener(cancelOnClickListener);
    }

    @Override
    public void setOkBtn(int textId, View.OnClickListener okOnClickListener) {
        mOkTv.setText(textId);
        setOnOkClickListener(okOnClickListener);
    }

    @Override
    public void setOkBtn(CharSequence text, View.OnClickListener okOnClickListener) {
        mOkTv.setText(text);
        setOnOkClickListener(okOnClickListener);
    }


    @Override
    public void setOkBtnStyleType(int okBtnStyleType) {
        mOkTv.setBackgroundResource(DialogUtil.getOkBtnBgResId(okBtnStyleType));
        mOkTv.setTextColor(DialogUtil.getOkBtnTextColorValue(okBtnStyleType, mOkTv.getContext()));
    }

    @Override
    public void bindAllListeners() {
        mCancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogType5.this.onCancelClick(v);
            }
        });
        mOkTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogType5.this.onOkClick(v);
            }
        });
    }
}
