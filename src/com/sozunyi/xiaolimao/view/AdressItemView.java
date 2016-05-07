package com.sozunyi.xiaolimao.view;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.UpdateAdressActivity;
import com.sozunyi.xiaolimao.entity.AdressInfo;
import com.sozunyi.xiaolimao.view.OrdersItemView.ImyCallBack;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AdressItemView extends RelativeLayout {

	private TextView tvName;
	private TextView tvPhone;
	private TextView tvAdress;
	private CheckBox ckDefaultAdress;
	private Button btnEdit;
	private Button btnDelete;
	
	private AdressInfo adressInfo;
	
	public interface ImyCallBack{
		public void onEditClick(View v);
		public void onDeleteClick(View v);
		public void onDefaultCheckedChanged(CompoundButton buttonView, boolean isChecked);
	}
	
	 /**  初始化接口变量   */  
    ImyCallBack icallBack = null;  
      
    /** 自定义控件的自定义事件 
     * @param iBack 接口类型 
     */  
    public void setonClick(ImyCallBack iBack)  
    {  
        icallBack = iBack;  
    }  

	public AdressItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		initView(context);
	}

	public AdressItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
 		initView(context);
	}

	public AdressItemView(Context context) {
		super(context);
		initView(context);
	}
	/**
	 * 
	 */
	private void initView(final Context context){
		View v = View.inflate(getContext(), R.layout.view_item_adress, this);
		tvName = (TextView) v.findViewById(R.id.iv_item_adress_name);
		tvPhone = (TextView) v.findViewById(R.id.tv_item_adress_phone);
		tvAdress = (TextView) v.findViewById(R.id.tv_item_adress);
		
		ckDefaultAdress = (CheckBox) v.findViewById(R.id.ck_item_default);
		btnEdit = (Button) v.findViewById(R.id.btn_item_edit);
		btnDelete  = (Button) v.findViewById(R.id.btn_item_delete);
		
		btnEdit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icallBack.onEditClick(v);
			}
		});
		ckDefaultAdress.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				icallBack.onDefaultCheckedChanged(buttonView, isChecked);
			}
		});
		btnDelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icallBack.onDeleteClick(v);
			}
		});
	}
	
	/**
	 * 设置控件显示内容
	 * @param info
	 */
	public void setAdressInfo(AdressInfo info)
	{
		if(info !=null){
			this.adressInfo = info;
			tvName.setText(adressInfo.getName());
			tvPhone.setText(adressInfo.getPhone());
			tvAdress.setText(adressInfo.getAdress());
			setDefaultAdressCleck(adressInfo.getDefaultAdress());
		}
	}
	
	/**
	 * 设置默认选项框勾选状态
	 * @param checked
	 */
	public void setDefaultAdressCleck(boolean checked){
		ckDefaultAdress.setChecked(checked);
		Drawable img_on, img_off;  
		Resources res = getResources();  
		img_off = res.getDrawable(R.drawable.default_adress_unclicked);  
		img_on  = res.getDrawable(R.drawable.default_adress_clicked); 
		//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示  
		img_on.setBounds(0, 0, img_on.getMinimumWidth(), img_on.getMinimumHeight());
		img_off.setBounds(0, 0, img_off.getMinimumWidth(), img_off.getMinimumHeight());
		if(ckDefaultAdress.isChecked()){
			
			ckDefaultAdress.setCompoundDrawables(img_on, null, null, null);
			ckDefaultAdress.setTextColor(0xff0084ff);
			ckDefaultAdress.setText("默认地址");
			
		}else{
			ckDefaultAdress.setCompoundDrawables(img_off, null, null, null);
			ckDefaultAdress.setTextColor(0xff555555);
			ckDefaultAdress.setText("设为默认");
		}
	}

	public AdressInfo getDressInfo() {
		return adressInfo;
	}

	public void setDressInfo(AdressInfo dressInfo) {
		this.adressInfo = dressInfo;
	}

}






