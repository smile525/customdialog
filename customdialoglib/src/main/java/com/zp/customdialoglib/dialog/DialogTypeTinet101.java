package com.zp.customdialoglib.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zp.customdialoglib.R;


/**
 * 类型5 Dialog
 * 有标题，带两个输入框
 */

public class DialogTypeTinet101 extends DialogBase {
    private TextView mOkTv;
    private TextView mCancelTv;
    private EditText mContentEd, mContentEd1;

    public DialogTypeTinet101(Context context) {
        super(context);
    }

    @Override
    public void initDialog() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.common_dialog_layout_type_tinet_101, null);
        mTitleTv = (TextView) rootView.findViewById(R.id.common_dialog_title_text);
        mOkTv = (TextView) rootView.findViewById(R.id.common_dialog_ok_btn);
        mCancelTv = (TextView) rootView.findViewById(R.id.common_dialog_cancel_btn);
        mContentEd = (EditText) rootView.findViewById(R.id.common_dialog_edit_text);
        mContentEd1 = (EditText) rootView.findViewById(R.id.common_dialog_edit_text1);
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
    public EditText getEditText1() {
        return mContentEd1;
    }

    @Override
    public void setContentEd1(String text) {
        this.mContentEd1.setText(text);
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
                DialogTypeTinet101.this.onCancelClick(v);
            }
        });
        mOkTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogTypeTinet101.this.onOkClick(v);
            }
        });
    }
}
