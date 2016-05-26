package com.allen.study.main;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.allen.study.R;
import com.allen.study.base.BaseActivity;
import com.allen.study.main.presenter.IMainPresenter;
import com.allen.study.main.presenter.MainPresenterCompl;
import com.allen.study.main.view.IMainView;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by ChenRan on 2016-2-25.
 */
public class MainActivity extends BaseActivity implements IMainView {
	private Context mContext;

	@InjectView(R.id.main_listView)
	ListView mListView;

	private IMainPresenter mIMainPresenter;

	@Override
	protected void onBeforeSetContentLayout(){
		mContext = this;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	public void initView() {
		mIMainPresenter = new MainPresenterCompl(this);
	}

	@Override
	public void initData() {
		super.initData();
	}

	@Override
	public void onShowList() {
		mListView.setVisibility(View.VISIBLE);
	}

	@Override
	public void onSetProgressBarVisibility(boolean show) {
		if(show)
			showWaitDialog();
		else
			hideWaitDialog();
	}

	@Override
	public ListView getListView() {
		return mListView;
	}

	@Override
	public Context getContext() {
		return mContext;
	}

	@Override
	@OnClick(R.id.main_button)
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.main_button:
				onSetProgressBarVisibility(true);
				mIMainPresenter.loadData();
				break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
