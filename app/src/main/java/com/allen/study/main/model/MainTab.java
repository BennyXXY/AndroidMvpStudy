package com.allen.study.main.model;

import com.allen.study.R;

/**
 * 主页上的tab项目
 * Created by ChenRan on 2016-3-22.
 */
public enum MainTab {

	ZHIHU(0, R.string.main_tab_name_zhihu, R.drawable.tab_icon_new, null),
	OSCHINA(1,R.string.main_tab_name_osChina, R.drawable.tab_icon_new, null),
	EXPLORE(2, R.string.main_tab_name_explore, R.drawable.tab_icon_explore, null),
	ME(3, R.string.main_tab_name_my, R.drawable.tab_icon_me, null);

	private int idx;
	private int resName;
	private int resIcon;
	private Class<?> clz;

	private MainTab(int idx, int resName, int resIcon, Class<?> clz){
		this.idx = idx;
		this.resName = resName;
		this.resIcon = resIcon;
		this.clz = clz;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getResName() {
		return resName;
	}

	public void setResName(int resName) {
		this.resName = resName;
	}

	public int getResIcon() {
		return resIcon;
	}

	public void setResIcon(int resIcon) {
		this.resIcon = resIcon;
	}

	public Class<?> getClz() {
		return clz;
	}

	public void setClz(Class<?> clz) {
		this.clz = clz;
	}
}
