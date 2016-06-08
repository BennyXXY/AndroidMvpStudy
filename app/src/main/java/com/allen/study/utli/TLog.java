package com.allen.study.utli;

import android.util.Log;

/**
 * 日志控制统一类
 */
public class TLog {
	public static final String LOG_TAG = "TLog";
	public static boolean DEBUG = true;

	public TLog() {
	}

	public static final void d(String log) {
		if (DEBUG)
			Log.d(LOG_TAG, log);
	}

	public static final void d(String tag,String log) {
		if (DEBUG)
			Log.d(tag, log);
	}

	public static final void e(String log) {
		if (DEBUG)
			Log.e(LOG_TAG, "" + log);
	}

	public static final void e(String tag,String log) {
		if (DEBUG)
			Log.e(tag, log);
	}

	public static final void i(String log) {
		if (DEBUG)
			Log.i(LOG_TAG, log);
	}

	public static final void i(String tag, String log) {
		if (DEBUG)
			Log.i(tag, log);
	}

	public static final void v(String log) {
		if (DEBUG)
			Log.v(LOG_TAG, log);
	}

	public static final void v(String tag,String log) {
		if (DEBUG)
			Log.v(tag, log);
	}

	public static final void w(String log) {
		if (DEBUG)
			Log.w(LOG_TAG, log);
	}

	public static final void w(String tag,String log) {
		if (DEBUG)
			Log.w(tag, log);
	}
}
