package com.sozunyi.xiaolimao.pager.impl;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.OrderDetailsActivity;
import com.sozunyi.xiaolimao.adapter.OrdersAdapter;
import com.sozunyi.xiaolimao.entity.GoodsInfo;
import com.sozunyi.xiaolimao.entity.OrdersInfo;
import com.sozunyi.xiaolimao.pager.BasePager;
import com.sozunyi.xiaolimao.view.RefreshListView;
import com.sozunyi.xiaolimao.view.RefreshListView.OnRefreshListener;

/** * 订单页* @author chen */
public class OrderPage extends BasePager {
	
private RefreshListView refreshListView;
	
	private ArrayList<OrdersInfo> lists;
	private ArrayList<GoodsInfo> listGoods;

	private OrdersAdapter ordersAdapter;
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			//更新UI
			ordersAdapter.notifyDataSetChanged();
			refreshListView.completeRefresh();
		};
	};

	public OrderPage(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initViews() {
		mRootView = View.inflate(mActivity, R.layout.activity_orders, null);
		refreshListView = (RefreshListView) mRootView.findViewById(R.id.refreshListView);
		
		initData();
		
		return mRootView;
	}
	
	
	public void initData(){
		lists = new ArrayList<OrdersInfo>();
		for (int i = 0; i < 4; i++) {
			OrdersInfo ordersInfo = new OrdersInfo();
			ordersInfo.setCarriage(5);
			ordersInfo.setCount(6);
			ordersInfo.setOrderDate(new Date());
			ordersInfo.setOrderStates(0);
			ordersInfo.setShopName("李家猪脚饭");
			ordersInfo.setTotalPrice(590);
			
			listGoods = new ArrayList<GoodsInfo>();
			for(int j=0;j<4;j++){
				GoodsInfo goodsInfo = new GoodsInfo();
				goodsInfo.setCount(2);
				goodsInfo.setGoodsName("烧猪脚");
				goodsInfo.setPrice(88);
				listGoods.add(goodsInfo);
			}
			ordersInfo.setListGoods(listGoods);
			
			lists.add(ordersInfo);
		}

		ordersAdapter = new OrdersAdapter(lists, mActivity);
		refreshListView.setAdapter(ordersAdapter);
		
		refreshListView.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onPullRefresh() {
				//需要联网请求服务器的数据，然后更新UI
				requestDataFromServer(false);
			}
		});
		refreshListView.setOnItemClickListener(new AbsListView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
					  int position, long id) {
					System.out.println("我点击了这里的");
					mActivity.startActivity(new Intent(mActivity,OrderDetailsActivity.class));
					  //获取选中的项
					  final OrdersInfo ordersInfo = (OrdersInfo) refreshListView.getItemAtPosition(position);
					}
	   	 });

		
	}
	
	/**
	 * 模拟向服务器请求数据
	 */
	private void requestDataFromServer(final boolean isLoadingMore){
		new Thread(){
			public void run() {
				SystemClock.sleep(3000);//模拟请求服务器的一个时间长度
				
				if(isLoadingMore){
//					list.add("加载更多的数据-1");
//					list.add("加载更多的数据-2");
//					list.add("加载更多的数据-3");
				}else {
//					list.add(0, "下拉刷新的数据");
				}
				
				//在UI线程更新UI
				handler.sendEmptyMessage(0);
			};
		}.start();
	}
}
