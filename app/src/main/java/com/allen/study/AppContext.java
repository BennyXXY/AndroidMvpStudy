package com.allen.study;

import android.app.Application;

import com.allen.study.base.BaseApplication;

/**
 * 全局应用程序类：用于保存和调用全局应用配置及访问网络数据
 * Created by ChenRan on 2016-2-25.
 */
public class AppContext extends BaseApplication {

	public static final int PAGE_SIZE = 20;// 默认分页大小

	private static AppContext instance;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		init();
	}

	/**
	 * 获得当前app运行的AppContext
	 *
	 * @return
	 */
	public static AppContext getInstance() {
		return instance;
	}

	/**
	 * 初始化操作
	* */
	private void init(){

	}
}
