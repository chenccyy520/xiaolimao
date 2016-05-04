package com.sozunyi.xiaolimao.pager.impl;

import android.app.Activity;
import android.view.View;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.pager.BasePager;

public class ShoppingCartPage extends BasePager {
	
	public ShoppingCartPage(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initViews() {
		return flContent;
	}

}
