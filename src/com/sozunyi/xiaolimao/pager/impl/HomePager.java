package com.sozunyi.xiaolimao.pager.impl;


import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.HomeActivity;
import com.sozunyi.xiaolimao.activity.LocationActivity;
import com.sozunyi.xiaolimao.activity.SearchActivity;
import com.sozunyi.xiaolimao.adapter.HomeAdapter;
import com.sozunyi.xiaolimao.common.BaseGetLocation;
import com.sozunyi.xiaolimao.pager.BasePager;
import com.sozunyi.xiaolimao.service.LocationService;
import com.sozunyi.xiaolimao.view.MarqueeTextView;

/**
 * 首页
 * 
 * @author chen
 * 
 */
public class HomePager extends BasePager{
	
	private LocationService locationService;
	private GridView gvHome;
	private String[] mItems;//goods
	private String[] mItemjns;//jineng
	private int[] mPicjnID;
	private int[] mPicID ;
	
	private GridView gvJiNeng;//技能
	

	private MarqueeTextView mTvLocation;//定位
	private EditText mSearchBox = null;
	
	public HomePager(Activity activity) {
		super(activity);
	}
	
	@Override
	public View initViews() {
		mRootView = View.inflate(mActivity, R.layout.activity_home, null);
		init();
		
		//商品添加
		HomeAdapter myadapter = new HomeAdapter(mActivity,mItems,mPicID);
		gvHome.setAdapter(myadapter);
		//技能添加
		HomeAdapter myadapter1 = new HomeAdapter(mActivity,mItemjns,mPicjnID);
		gvJiNeng.setAdapter(myadapter1);
		
		clickListener();
		
//		new BaseGetLocation().startGetLocation();
//		mTvLocation.setText(BaseGetLocation.gettedLocation);
		return mRootView;
	}
	
	/**
	 * 初始化数据
	 */
	private void init(){
		gvHome = (GridView) mRootView.findViewById(R.id.gvHome);
		gvJiNeng = (GridView) mRootView.findViewById(R.id.gvJineng);
		mTvLocation = (MarqueeTextView) mRootView.findViewById(R.id.tv_main_location);
		mSearchBox = (EditText) mRootView.findViewById(R.id.index_search_edit);
		flContent = (FrameLayout) mRootView.findViewById(R.id.fl_content);
		
		mItems = new String[]{"美食","饮品","果蔬生鲜",
				"花草/宠物","衣/包/鞋/饰","美妆/护理","数码/居家","图文办公"};
		
		mPicID = new int[]{R.drawable.home_meishi,R.drawable.home_yingpin,R.drawable.home_shuiguo,
				R.drawable.home_xianhua,R.drawable.home_yifu,R.drawable.home_meizhuang,
				R.drawable.home_jujia,R.drawable.home_bangong};

		mItemjns = new String[]{"维修/开锁","家政/搬运","管道疏通",
				"衣物裁剪","代驾/陪练","摄影/剪辑","作业辅导","占卜算命"};
		
		mPicjnID = new int[]{R.drawable.home_zhuangxiu,R.drawable.home_jiazheng,R.drawable.home_shutong,
				R.drawable.home_caijian,R.drawable.home_peilian,R.drawable.home_sheying,
				R.drawable.home_zuoye,R.drawable.home_suanming};
		
		//不让滚动
		gvHome.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return MotionEvent.ACTION_MOVE == event.getAction() ? true
                        : false;
			}
		});
		gvJiNeng.setOnTouchListener(new OnTouchListener() {
					
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						return MotionEvent.ACTION_MOVE == event.getAction() ? true
		                        : false;
					}
				});
	}
	
	/**
	 * 设置按钮监听
	 */
	private void clickListener(){
		mSearchBox.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//启动activit
				mActivity.startActivity(new Intent(mActivity,SearchActivity.class));
			}
		});
		
		mTvLocation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//启动activit
				mActivity.startActivity(new Intent(mActivity,LocationActivity.class));
			}
		});
	}
	
	public void initData(){
		
	}

}

