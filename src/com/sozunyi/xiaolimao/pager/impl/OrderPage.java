package com.sozunyi.xiaolimao.pager.impl;

import android.app.Activity;
import android.view.View;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.pager.BasePager;

/**
 * 订单页
 * @author chen
 *
 */
public class OrderPage extends BasePager {

	public OrderPage(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initViews() {
		mRootView = View.inflate(mActivity, R.layout.activity_orders, null);
		
		return mRootView;
	}
	
	
	public void initData(){
		
	}

}
