package com.allen.mvpdemo.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.allen.mvpdemo.R;
import com.allen.mvpdemo.main.presenter.IMainPresenter;
import com.allen.mvpdemo.main.presenter.MainPresenterCompl;
import com.allen.mvpdemo.main.view.IMainView;

import java.util.List;

/**
 * Created by ChenRan on 2016-2-25.
 */
public class MainActivity extends AppCompatActivity implements IMainView,View.OnClickListener {

	private Button mButton;
	private ListView mListView;
	private ProgressBar mProgressBar;
	private IMainPresenter mIMainPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton = (Button) this.findViewById(R.id.main_button);
		mListView = (ListView) this.findViewById(R.id.main_listView);
		mProgressBar = (ProgressBar) this.findViewById(R.id.main_progress);

		mButton.setOnClickListener(this);

		mIMainPresenter = new MainPresenterCompl(this);
		mIMainPresenter.setProgressBarVisiblity(View.INVISIBLE);
	}

	@Override
	public void onShowList() {
		mListView.setVisibility(View.VISIBLE);
	}

	@Override
	public void onSetProgressBarVisibility(int visibility) {
		mProgressBar.setVisibility(visibility);
	}

	@Override
	public ListView getListView() {
		return mListView;
	}

	@Override
	public Context getContext() {
		return MainActivity.this;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.main_button:
				mIMainPresenter.setProgressBarVisiblity(View.VISIBLE);
				mIMainPresenter.loadData();
				break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
