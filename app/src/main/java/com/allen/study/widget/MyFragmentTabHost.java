package com.allen.study.widget;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;

/**
 * 自定义tabHost类，继承基类
 * Created by ChenRan on 2016-3-22.
 */
public class MyFragmentTabHost extends FragmentTabHost {

	private String mCurrentTag;
	private String mNoTabChangedTag;

	public MyFragmentTabHost(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void onTabChanged(String tabId) {
		super.onTabChanged(tabId);
	}
}
