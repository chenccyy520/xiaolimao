package com.sozunyi.xiaolimao.activity;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.base.BaseActivity;
import com.sozunyi.xiaolimao.adapter.AdressAdapter;
import com.sozunyi.xiaolimao.entity.AdressInfo;
import com.sozunyi.xiaolimao.entity.CollectionShop;
import com.sozunyi.xiaolimao.view.AdressItemView;
import com.sozunyi.xiaolimao.view.CollectionShopView;

public class CollectionActivity extends BaseActivity {
	
	@ViewInject(R.id.tv_collection_shop)
	private LinearLayout layCollectionItem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_collection);
		
		layCollectionItem = (LinearLayout) findViewById(R.id.lay_collection);
		//initUI();
		initData();
	}
	
	private void initData(){
		
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
		
		CollectionShopView view1 = new CollectionShopView(this);
		view1.SetVilue(collectionShop);
		layCollectionItem.addView(view1, 0);
		
		collectionShop.setDistributionFee(9);
		collectionShop.setID(2);
		collectionShop.setNotice("");
		collectionShop.setOpenTime("9:00-21:00");
		collectionShop.setPhone("15252567676");
		collectionShop.setShopAdress("汇川区上海路850号");
		collectionShop.setShopName("谭记豆花饭");
		collectionShop.setStar(1);
		collectionShop.setWeChatNum("c4543231");
 		
		CollectionShopView view2 = new CollectionShopView(this);
    	view2.SetVilue(collectionShop);
    	layCollectionItem.addView(view2, 1);
    	
    	collectionShop.setDistributionFee(12);
		collectionShop.setID(2);
		collectionShop.setNotice("");
		collectionShop.setOpenTime("10:00-23:00");
		collectionShop.setPhone("13312455678");
		collectionShop.setShopAdress("黄花岗区中华北路28号");
		collectionShop.setShopName("董哥米粉");
		collectionShop.setStar(1);
		collectionShop.setWeChatNum("chen343");
    	CollectionShopView view3 = new CollectionShopView(this);
    	view3.SetVilue(collectionShop);
    	layCollectionItem.addView(view3, 2);
    	
    	collectionShop.setDistributionFee(5);
		collectionShop.setID(2);
		collectionShop.setNotice("");
		collectionShop.setOpenTime("8:00-23:00");
		collectionShop.setPhone("18798181868");
		collectionShop.setShopAdress("大连路203号医学院旁");
		collectionShop.setShopName("湖南大碗菜");
		collectionShop.setStar(1);
		collectionShop.setWeChatNum("hndwccaca");
    	
    	CollectionShopView view4 = new CollectionShopView(this);
    	view4.SetVilue(collectionShop);
    	layCollectionItem.addView(view4, 3);
    	
    	CollectionShopView view5 = new CollectionShopView(this);
    	view5.SetVilue(collectionShop);
    	layCollectionItem.addView(view5, 4);
    	
    	CollectionShopView view6 = new CollectionShopView(this);
    	view6.SetVilue(collectionShop);
    	layCollectionItem.addView(view6, 5);
 	}
	
	private void initUI() {
        
        //设置listView的触摸点击监听
        //mySetOnItemClickListener();
       
    }
	
}




