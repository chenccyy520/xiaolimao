package com.sozunyi.xiaolimao.pager.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.AdressActivity;
import com.sozunyi.xiaolimao.activity.CollectionActivity;
import com.sozunyi.xiaolimao.activity.PersonalInfoActivity;
import com.sozunyi.xiaolimao.activity.SettingActivity;
import com.sozunyi.xiaolimao.pager.BasePager;
import com.sozunyi.xiaolimao.view.PersonalItemView;

public class PersonalPage extends BasePager {
	
	private PersonalItemView piv_personalinfo;
	private PersonalItemView piv_adress;
	private PersonalItemView piv_shoucang;//收藏
	private PersonalItemView piv_woyaokaidian;
	private PersonalItemView piv_fuwuzhongxin;
	private PersonalItemView piv_setting;
	
	public PersonalPage(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initViews() {
		rootView = View.inflate(mActivity, R.layout.activity_personal, null);
		findViewById();
		setValue();
		clickListener();
		return rootView;
	}
	
	protected void findViewById() {
		piv_personalinfo = (PersonalItemView) rootView.findViewById(R.id.piv_personalinfo);
		piv_adress=(PersonalItemView) rootView.findViewById(R.id.piv_adress);
		piv_shoucang = (PersonalItemView) rootView.findViewById(R.id.piv_shoucang);
		piv_woyaokaidian = (PersonalItemView) rootView.findViewById(R.id.piv_woyaokaidian);
		piv_fuwuzhongxin = (PersonalItemView) rootView.findViewById(R.id.piv_fuwuzhongxin);
		piv_setting = (PersonalItemView) rootView.findViewById(R.id.piv_setting);
	}
	
	protected void setValue() {
		piv_personalinfo.setImage(R.drawable.myinfo);
		piv_adress.setImage(R.drawable.shouhuodizhi);
		piv_shoucang.setImage(R.drawable.wodeshoucang);
		piv_woyaokaidian.setImage(R.drawable.woyaokaidian);
		piv_fuwuzhongxin.setImage(R.drawable.fuwuzhongxin);
		piv_setting.setImage(R.drawable.shezhi);
	}
	
	private void clickListener(){
		piv_personalinfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mActivity.startActivity(new Intent(mActivity,PersonalInfoActivity.class));
			}
		});
		
		piv_adress.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mActivity.startActivity(new Intent(mActivity,AdressActivity.class));
			}
		});
		
		piv_setting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mActivity.startActivity(new Intent(mActivity,SettingActivity.class));
			}
		});
		
		piv_shoucang.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mActivity.startActivity(new Intent(mActivity,CollectionActivity.class));
			}
		});
	}

}
