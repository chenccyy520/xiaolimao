package com.sozunyi.xiaolimao.adapter;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.sozunyi.xiaolimao.pager.BasePager;

/**
 * ContentAdapter适配器
 * @author chen
 *
 */
public class ContentAdapter extends PagerAdapter {
	
	private ArrayList<BasePager> mPagerList;
	
	public ContentAdapter(ArrayList<BasePager> mPagerList ){
		this.mPagerList = mPagerList;
	}
	
	//viewpager中的组件数量
    @Override
	public int getCount() {
		return mPagerList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	//每次滑动的时候生成的组件
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		BasePager pager = mPagerList.get(position);
		container.addView(pager.rootView);
		// pager.initData();// 初始化数据.... 不要放在此处初始化数据, 否则会预加载下一个页面
		return pager.rootView;
	}
	 //切换的时候销毁当前的组件
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

}
