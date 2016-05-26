package com.allen.study;

import android.app.Application;

import com.allen.study.base.BaseApplication;

/**
 * Created by ChenRan on 2016-2-25.
 */
public class AppContext extends BaseApplication {

	private static AppContext instance;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	/**
	 * 获得当前app运行的AppContext
	 *
	 * @return
	 */
	public static AppContext getInstance() {
		return instance;
	}
}
