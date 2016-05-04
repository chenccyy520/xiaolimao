package com.sozunyi.xiaolimao.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.base.BaseActivity;
import com.sozunyi.xiaolimao.adapter.AdressAdapter;
import com.sozunyi.xiaolimao.entity.AdressInfo;
import com.sozunyi.xiaolimao.view.AdressItemView;

public class AdressActivity extends BaseActivity {
	
	private String mName;
	private String mPhone;
	private String mAdress;
	
	private AdressAdapter adapter;
	private LinearLayout lay_adress_item;
    private List<AdressInfo> adressInfos;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_adress);
		
		lay_adress_item = (LinearLayout) findViewById(R.id.lay_adress_item);
		//initUI();
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
		 
		 mName = "刘郴榆";
	 	 mPhone = "18798125204";
	 	 mAdress = "贵州省遵义市汇川区上海路830号";
		 AdressItemView view1 = new AdressItemView(this);
		 view1.setName(mName);
		 view1.setPhone(mPhone);
		 view1.setAdress(mAdress);
		 view1.setAddStatesFromChildren(true);
		 lay_adress_item.addView(view1, 0);
    	
    	mName = "陈昌政";
 		mPhone = "17098895202";
 		mAdress = "贵州省遵义市红花岗区中华路890号";
 		
    	AdressItemView view2 = new AdressItemView(this);
		view2.setName(mName);
		view2.setPhone(mPhone);
		view2.setAdress(mAdress);
		view2.setAddStatesFromChildren(false);
		lay_adress_item.addView(view2, 1);		
 		
 		mName = "小明";
 		mPhone = "17098895202";
 		mAdress = "贵州省贵阳市观山湖区中华路890号";
 		AdressItemView view3 = new AdressItemView(this);
		view3.setName(mName);
		view3.setPhone(mPhone);
		view3.setAdress(mAdress);
		view3.setAddStatesFromChildren(false);
 		
		lay_adress_item.addView(view3, 2);
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




