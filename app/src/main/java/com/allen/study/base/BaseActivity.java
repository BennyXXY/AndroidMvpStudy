package com.allen.study.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.allen.study.AppManager;
import com.allen.study.R;
import com.allen.study.interf.BaseViewInterface;
import com.allen.study.ui.dialog.CommonToast;
import com.allen.study.ui.dialog.DialogControl;
import com.allen.study.utli.DialogHelp;
import com.allen.study.utli.StringUtils;
import com.allen.study.utli.TDevice;

import butterknife.ButterKnife;

/**
 * 基础的Activity
 * Created by ChenRan on 2016-3-23.
 */
public class BaseActivity extends AppCompatActivity implements DialogControl, View.OnClickListener, BaseViewInterface {
	private boolean mIsVisible;
	private ProgressDialog mWaitDialog;

	protected LayoutInflater mInflater;
	protected ActionBar mActionBar;
	private TextView mTvActionTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		AppManager.getInstance().addActivity(this);
		if (!hasActionBar()) {
			supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
		}
		onBeforeSetContentLayout();
		if (getLayoutId() != 0) {
			setContentView(getLayoutId());
		}
		mActionBar = getSupportActionBar();
		mInflater = getLayoutInflater();
		if (hasActionBar()) {
			initActionBar(mActionBar);
		}

		// 通过注解绑定控件
		ButterKnife.inject(this);
		init(savedInstanceState);
		initView();
		initData();
		mIsVisible = true;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		TDevice.hideSoftKeyboard(getCurrentFocus());
		ButterKnife.reset(this);
	}

	@Override
	public void initView() {

	}

	@Override
	public void initData() {

	}

	@Override
	public void hideWaitDialog() {
		if (mIsVisible && mWaitDialog != null) {
			try {
				mWaitDialog.dismiss();
				mWaitDialog = null;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public ProgressDialog showWaitDialog() {
		return showWaitDialog(R.string.loading);
	}

	@Override
	public ProgressDialog showWaitDialog(int resid) {
		return showWaitDialog(getString(resid));
	}

	@Override
	public ProgressDialog showWaitDialog(String text) {
		if (mIsVisible) {
			if (mWaitDialog == null) {
				mWaitDialog = DialogHelp.getWaitDialog(this, text);
			}
			if (mWaitDialog != null) {
				mWaitDialog.setMessage(text);
				mWaitDialog.show();
			}
			return mWaitDialog;
		}
		return null;
	}

	@Override
	public void onClick(View v) {

	}

	protected void onBeforeSetContentLayout() {}

	protected boolean hasActionBar() {
		return true;
	}

	protected int getLayoutId() {
		return 0;
	}

	protected View inflateView(int resId) {
		return mInflater.inflate(resId, null);
	}

	protected int getActionBarTitle() {
		return R.string.app_name;
	}

	protected boolean hasBackButton() {
		return false;
	}

	protected void init(Bundle savedInstanceState) {}

	protected void initActionBar(ActionBar actionBar) {
		if (actionBar == null)
			return;
		if (hasBackButton()) {
			mActionBar.setDisplayHomeAsUpEnabled(true);
			mActionBar.setHomeButtonEnabled(true);
		} else {
			actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
			actionBar.setDisplayUseLogoEnabled(false);
			int titleRes = getActionBarTitle();
			if (titleRes != 0) {
				actionBar.setTitle(titleRes);
			}
		}
	}

	public void setActionBarTitle(int resId) {
		if (resId != 0) {
			setActionBarTitle(getString(resId));
		}
	}

	public void setActionBarTitle(String title) {
		if (StringUtils.isEmpty(title)) {
			title = getString(R.string.app_name);
		}
		if (hasActionBar() && mActionBar != null) {
			if (mTvActionTitle != null) {
				mTvActionTitle.setText(title);
			}
			mActionBar.setTitle(title);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				onBackPressed();
				break;

			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	public void showToast(int msgResid, int icon, int gravity) {
		showToast(getString(msgResid), icon, gravity);
	}

	public void showToast(String message, int icon, int gravity) {
		CommonToast toast = new CommonToast(this);
		toast.setMessage(message);
		toast.setMessageIc(icon);
		toast.setLayoutGravity(gravity);
		toast.show();
	}

}
