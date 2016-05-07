package com.sozunyi.xiaolimao.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.base.BaseActivity;
import com.sozunyi.xiaolimao.adapter.CollectionAdapter;
import com.sozunyi.xiaolimao.entity.CollectionShop;
import com.sozunyi.xiaolimao.view.RefreshListView;
import com.sozunyi.xiaolimao.view.RefreshListView.OnRefreshListener;

public class CollectionActivity extends BaseActivity {
	
	private RefreshListView refreshListView;
	private ArrayList<CollectionShop> collectionShops;
	private CollectionAdapter adapter;
	
	private Handler handler = new Handler(){
			public void handleMessage(android.os.Message msg) {
				//更新UI
			adapter.notifyDataSetChanged();
			refreshListView.completeRefresh();
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_collection);
		
		refreshListView = (RefreshListView) findViewById(R.id.refreshListView_collection);
		//initUI();
		initData();
	}
	
	private void initData(){
		
		collectionShops = new ArrayList<CollectionShop>();
		
		for(int i=0;i<10;i++){
			CollectionShop collectionShop = new CollectionShop();
			collectionShop.setDistributionFee(5);
			collectionShop.setID(2);
			collectionShop.setNotice("");
			collectionShop.setOpenTime("8:00-23:00");
			collectionShop.setPhone("18798165456");
			collectionShop.setShopAdress("汇川区宁波路29号");
			collectionShop.setShopName("辣得笑");
			collectionShop.setStar(1);
			collectionShop.setWeChatNum("chencc9812");
			collectionShops.add(collectionShop);
		}
		
		adapter = new CollectionAdapter(collectionShops, this);
		refreshListView.setAdapter(adapter);
		
		refreshListView.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onPullRefresh() {
				//需要联网请求服务器的数据，然后更新UI
				requestDataFromServer(false);
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
								
				//在UI线程更新UI
				handler.sendEmptyMessage(0);
			};
		}.start();
	}

	
}




