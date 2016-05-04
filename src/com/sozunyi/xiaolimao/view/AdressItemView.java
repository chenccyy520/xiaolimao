package com.sozunyi.xiaolimao.view;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.UpdateAdressActivity;

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
	private TextView tvID;
	private CheckBox ckDefaultAdress;
	private Button btnEdit;
	private Button btnDelete;
	
	private String mAddressee;
	private String mPhone;
	private String mAdress;
	int id;
	
	public String getmAddressee() {
		return mAddressee;
	}

	public void setmAddressee(String mAddressee) {
		this.mAddressee = mAddressee;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getmAdress() {
		return mAdress;
	}

	public void setmAdress(String mAdress) {
		this.mAdress = mAdress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		tvID = (TextView) v.findViewById(R.id.tv_adress_id);
		
		ckDefaultAdress = (CheckBox) v.findViewById(R.id.ck_item_default);
		btnEdit = (Button) v.findViewById(R.id.btn_item_edit);
		btnDelete  = (Button) v.findViewById(R.id.btn_item_delete);
		
		btnEdit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				context.startActivity(new Intent(context,UpdateAdressActivity.class));
			}
		});
		ckDefaultAdress.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				setDefaultAdressCleck(isChecked);
				
			}
		});
		btnDelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "我点击了删除按钮", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	/**
	 * 设置收件人姓名
	 * @param title
	 */
	public void setName(String name)
	{
		tvName.setText(name);
	}
	
	/**
	 * 设置收件电话
	 * @param value
	 */
	public void setPhone(String value){
		tvPhone.setText(value);
	}
	
	/**
	 * 设置收件地址
	 * @param a
	 */
	public void setAdress(String a){
		tvAdress.setText(a);
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

}






