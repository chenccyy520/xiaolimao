package com.sozunyi.xiaolimao.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.base.BaseActivity;
import com.sozunyi.xiaolimao.adapter.AdressAdapter;
import com.sozunyi.xiaolimao.entity.AdressInfo;
import com.sozunyi.xiaolimao.view.RefreshListView;
import com.sozunyi.xiaolimao.view.RefreshListView.OnRefreshListener;

public class AdressActivity extends BaseActivity {
	
	private AdressAdapter adapter;
	private RefreshListView refreshListView_adress;
    private ArrayList<AdressInfo> adressInfos;	
    
    private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			//更新UI
			adapter.notifyDataSetChanged();
			refreshListView_adress.completeRefresh();
		};
	};
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_adress);
		
		refreshListView_adress = (RefreshListView) findViewById(R.id.refreshListView_adress);
		
		initData();
	}
	
	private void initData(){
		
		 HttpUtils http = new HttpUtils(); 
		 http.send(HttpRequest.HttpMethod.GET, "http://192.168.10.126:8080/addr.json",
				 new RequestCallBack<String>(){

					@Override
					public void onSuccess(ResponseInfo responseInfo) {
						// TODO Auto-generated method stub
						//responseInfo.result
					}

					@Override
					public void onFailure(HttpException error, String msg) {
						// TODO Auto-generated method stub
						
					}
		 });
		 adressInfos = new  ArrayList<AdressInfo>();
		 for(int i=0;i<4;i++){
		 AdressInfo adressInfo = new AdressInfo();
		 adressInfo.setName("刘郴榆");
		 adressInfo.setPhone("18798125204");
		 adressInfo.setAdress("贵州省遵义市汇川区上海路830号");
		 adressInfos.add(adressInfo);
		 }
		 adapter = new AdressAdapter(adressInfos, this);
		 refreshListView_adress.setAdapter(adapter);
		 refreshListView_adress.setOnRefreshListener(new OnRefreshListener() {
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
				for(int i=0;i<4;i++){
					 AdressInfo adressInfo = new AdressInfo();
					 adressInfo.setName("陈昌政");
					 adressInfo.setPhone("18798125204");
					 adressInfo.setAdress("贵州省遵义市汇川区上海路830号");
					 adressInfos.add(adressInfo);
					 }
				
				//在UI线程更新UI
				handler.sendEmptyMessage(0);
			};
		}.start();
	}
	
	private void initUI() {
        
        //设置listView的触摸点击监听
        //mySetOnItemClickListener();
       
    }
	
	public void addNewAddr(View v){
		startActivity(new Intent(AdressActivity.this,AddAdressActivity.class));
	}
	
    /**
     * 设置listView的触摸点击监听
     
    private void mySetOnItemClickListener(){
    	 list_view.setOnItemClickListener(new OnItemClickListener() {

 			@Override
 			public void onItemClick(AdapterView<?> parent, View view,
 				  int position, long id) {
 				  //获取选中的项
 				  final AdressInfo blackNumberInfo = (AdressInfo) list_view.getItemAtPosition(position);
 				  final String num = blackNumberInfo.getNumber();//获取选中的电话号码
 				   
 				  AlertDialog.Builder buider = new AlertDialog.Builder(BlackCallActivity.this);
 				  final AlertDialog dlg = buider.create();
 			      View view1= View.inflate(BlackCallActivity.this, R.layout.black_num_more, null);
 				  dlg.setView(view1,5,5,5,5);
 				  //注意这里一定要用 view.findViewById 不然会出错
 				  TextView tvdelete = (TextView) view1.findViewById(R.id.tv_deleteblacknum);
 				  TextView tvCall = (TextView) view1.findViewById(R.id.tv_updateblacknum);
 				  tvCall.setText("拨打");
 				  //删除黑名单
 				  deleteNumber(blackNumberInfo, num, tvdelete, dlg);
 				  dlg.show();
 				}
    	 });
   }*/
	
}




