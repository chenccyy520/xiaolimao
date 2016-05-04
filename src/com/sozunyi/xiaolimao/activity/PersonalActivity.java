package com.sozunyi.xiaolimao.activity;

import android.os.Bundle;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.base.BaseActivity;
import com.sozunyi.xiaolimao.view.PersonalItemView;

public class PersonalActivity extends BaseActivity{
	private PersonalItemView piv_personalinfo;
	private PersonalItemView piv_adress;
	private PersonalItemView piv_shoucang;
	private PersonalItemView piv_woyaokaidian;
	private PersonalItemView piv_fuwuzhongxin;
	private PersonalItemView piv_setting;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal);
		findViewById();
		initView();
	}

	protected void initView() {
		piv_personalinfo.setImage(R.drawable.myinfo);
		piv_adress.setImage(R.drawable.shouhuodizhi);
		piv_shoucang.setImage(R.drawable.wodeshoucang);
		piv_woyaokaidian.setImage(R.drawable.woyaokaidian);
		piv_fuwuzhongxin.setImage(R.drawable.fuwuzhongxin);
		piv_setting.setImage(R.drawable.shezhi);
	}

	protected void findViewById() {
		piv_personalinfo = (PersonalItemView) findViewById(R.id.piv_personalinfo);
		
		piv_adress=(PersonalItemView) findViewById(R.id.piv_adress);
		
		piv_shoucang = (PersonalItemView) findViewById(R.id.piv_shoucang);
		
		piv_woyaokaidian = (PersonalItemView) findViewById(R.id.piv_woyaokaidian);
		
		piv_fuwuzhongxin = (PersonalItemView) findViewById(R.id.piv_fuwuzhongxin);
		
		piv_setting = (PersonalItemView) findViewById(R.id.piv_setting);
	}

}
