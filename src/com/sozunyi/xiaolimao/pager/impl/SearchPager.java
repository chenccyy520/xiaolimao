package com.sozunyi.xiaolimao.pager.impl;

import android.app.Activity;
import android.view.View;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.pager.BasePager;

public class SearchPager extends BasePager {
	
	public SearchPager(Activity activity) {
		super(activity);
	}

	@Override
	public View initViews() {
		rootView = View.inflate(mActivity, R.layout.activity_search, null);
		
		return rootView;
	}
	
	
	public void initData(){
		
	}

}
