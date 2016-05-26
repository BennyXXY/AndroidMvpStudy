package com.allen.study.ui.dialog;

import android.app.ProgressDialog;

/**
 * UI对话框接口
 * Created by ChenRan on 2016-3-23.
 */
public interface DialogControl {

	void hideWaitDialog();

	ProgressDialog showWaitDialog();

	ProgressDialog showWaitDialog(int resid);

	ProgressDialog showWaitDialog(String text);
}
