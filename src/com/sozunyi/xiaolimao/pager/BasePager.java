package com.sozunyi.xiaolimao.pager;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 主页下5个子页面的基类
 * 
 * @author chen
 * 
 */
public abstract  class BasePager {

	public Activity mActivity;
	public View mRootView;// 布局对象

	public FrameLayout flContent;// 内容
	
	public BasePager(Activity activity) {
		mActivity = activity;
		mRootView = initViews();
	}

	/**
	 * 初始化布局 子类必须实现
	 */
	public abstract View initViews();
	/**
	 * 初始化数据
	 */
	public void initData() {

	}
}
