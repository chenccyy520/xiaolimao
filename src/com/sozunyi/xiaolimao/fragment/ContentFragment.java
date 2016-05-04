package com.sozunyi.xiaolimao.fragment;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.adapter.ContentAdapter;
import com.sozunyi.xiaolimao.pager.BasePager;
import com.sozunyi.xiaolimao.pager.impl.HomePager;
import com.sozunyi.xiaolimao.pager.impl.OrderPage;
import com.sozunyi.xiaolimao.pager.impl.PersonalPage;
import com.sozunyi.xiaolimao.pager.impl.SearchPager;
import com.sozunyi.xiaolimao.pager.impl.ShoppingCartPage;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 主页内容
 * 
 * @author chenchangzheng
 * 
 */
public class ContentFragment extends BaseFragment {

	@ViewInject(R.id.home_radio_button_group)
	private RadioGroup rgGroup;
	
	@ViewInject(R.id.vp_content)
	private ViewPager mViewPager;
	
	private ArrayList<BasePager> mPagerList;

	@Override
	public View initViews() {
		View view = View.inflate(mActivity, R.layout.fragment_content, null);
		
		ViewUtils.inject(this, view); // 注入view和事件
		return view;
	}

	@Override
	public void initData() {
		rgGroup.check(R.id.home_tab_main);// 默认勾选首页

		// 初始化5个子页面
		mPagerList = new ArrayList<BasePager>();
		mPagerList.add(new HomePager(mActivity));
		mPagerList.add(new SearchPager(mActivity));
		mPagerList.add(new OrderPage(mActivity));
		mPagerList.add(new ShoppingCartPage(mActivity));
		mPagerList.add(new PersonalPage(mActivity));

		mViewPager.setAdapter(new ContentAdapter(mPagerList));

		// 监听RadioGroup的选择事件
		rgGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.home_tab_main:
					// mViewPager.setCurrentItem(0);// 设置当前页面
					mViewPager.setCurrentItem(0, false);// 去掉切换页面的动画
					break;
				case R.id.home_tab_search:
					mViewPager.setCurrentItem(1, false);// 设置当前页面
					break;
				case R.id.home_tab_order:
					mViewPager.setCurrentItem(2, false);// 设置当前页面
					break;
				case R.id.home_tab_cart:
					mViewPager.setCurrentItem(3, false);// 设置当前页面
					break;
				case R.id.home_tab_personal:
					mViewPager.setCurrentItem(4, false);// 设置当前页面
					break;

				default:
					break;
				}
			}
		});

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				mPagerList.get(arg0).initData();// 获取当前被选中的页面, 初始化该页面数据
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		mPagerList.get(0).initData();// 初始化首页数据
	}


	/**
	 * 获取新闻中心页面
	 * 
	 * @return
	 */
//	public NewsCenterPager getNewsCenterPager() {
//		return (NewsCenterPager) mPagerList.get(1);
//	}

}
