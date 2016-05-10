package com.sozunyi.xiaolimao.pager.impl;

import java.util.ArrayList;

import android.app.Activity;
import android.view.View;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.pager.BasePager;
import com.sozunyi.xiaolimao.view.ExpandTabView;
import com.sozunyi.xiaolimao.view.ViewLeft;
import com.sozunyi.xiaolimao.view.ViewMiddle;
import com.sozunyi.xiaolimao.view.ViewSimpleList;

public class SearchPager extends BasePager {
	
	private ExpandTabView expandTabView;
	private ArrayList<View> mViewArray; 
	private ViewLeft viewLeft;
	private ViewMiddle viewMiddle;
	private ViewSimpleList viewRight;
	
	public SearchPager(Activity activity) {
		super(activity);
	}

	@Override
	public View initViews() {
		mRootView = View.inflate(mActivity, R.layout.activity_search, null);
		expandTabView = (ExpandTabView) mRootView.findViewById(R.id.expandtab_view);
		mViewArray = new ArrayList<View>();
		viewLeft = new ViewLeft(mActivity);
		viewMiddle = new ViewMiddle(mActivity);
		//viewRight = new ViewSimpleList(mActivity);
		initVaule();

		return mRootView;
	}
	
	private void initVaule() {
		
		mViewArray.add(viewLeft);
		mViewArray.add(viewMiddle);
		mViewArray.add(viewRight);
		ArrayList<String> mTextArray = new ArrayList<String>();
		mTextArray.add("距离");
		mTextArray.add("区域");
		mTextArray.add("距离");
		expandTabView.setValue(mTextArray, mViewArray);
		//expandTabView.setTitle(viewLeft.getShowText(), 0);
		//expandTabView.setTitle(viewMiddle.getShowText(), 1);
		//expandTabView.setTitle(viewRight.getShowText(), 2);
		
	}
	
	public void initData(){
		
	}

}
