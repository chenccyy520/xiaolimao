package com.sozunyi.xiaolimao.activity;

import android.os.Bundle;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.base.BaseActivity;
import com.sozunyi.xiaolimao.view.TitleBarView;

public class AddAdressActivity extends BaseActivity {
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adress_add_update);
		
		TitleBarView tvTitle = (TitleBarView) findViewById(R.id.tbv_adress_add);
		tvTitle.setTitle("新增地址");
	}
	
	
	
}




