package com.sozunyi.xiaolimao.adapter;

import java.util.List;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.UpdateAdressActivity;
import com.sozunyi.xiaolimao.entity.AdressInfo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class AdressAdapter extends MyBaseAdapter<AdressInfo>  {
	
	 public AdressAdapter(List lists, Context mContext) {
         super(lists, mContext);
     }
	
	 @Override
     public View getView(int position, View convertView, ViewGroup parent) {
         final ViewHolder holder;
         if (convertView == null) {
             convertView = View.inflate(mContext, R.layout.view_item_adress, null);
             holder = new ViewHolder();
             holder.tvName = (TextView) convertView.findViewById(R.id.iv_item_adress_name);
             holder.tvPhone = (TextView) convertView.findViewById(R.id.tv_item_adress_phone);
             holder.tvAdress = (TextView) convertView.findViewById(R.id.tv_item_adress);
             holder.btnDelete = (Button) convertView.findViewById(R.id.btn_item_delete);
             holder.btnEdit = (Button) convertView.findViewById(R.id.btn_item_edit);
             holder.ckDefaultAddr = (CheckBox) convertView.findViewById(R.id.ck_item_default);
             convertView.setTag(holder);
         } else {
             holder = (ViewHolder) convertView.getTag();
         }
         //在以后的程序设计中，SETTEXT信息一定要转化成string 不然会报错
         holder.tvName.setText(lists.get(position).getName());
         holder.tvPhone.setText(lists.get(position).getPhone());
         holder.tvAdress.setText(lists.get(position).getAdress());
         holder.ckDefaultAddr.setChecked(lists.get(position).getDefaultAdress());
         holder.btnDelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "我点击了删除按钮", Toast.LENGTH_SHORT).show();
			}
		});
         
         holder.btnEdit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mContext.startActivity(new Intent(mContext,UpdateAdressActivity.class));
			}
		});
         
         	final Drawable img_on;
			final Drawable img_off;  
			Resources res = mContext.getResources();  
			img_off = res.getDrawable(R.drawable.default_adress_unclicked);  
			img_on  = res.getDrawable(R.drawable.default_adress_clicked); 
			//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示  
			img_on.setBounds(0, 0, img_on.getMinimumWidth(), img_on.getMinimumHeight());
			img_off.setBounds(0, 0, img_off.getMinimumWidth(), img_off.getMinimumHeight());
         
         holder.ckDefaultAddr.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					holder.ckDefaultAddr.setChecked(isChecked);
					
					if(holder.ckDefaultAddr.isChecked()){
						
						holder.ckDefaultAddr.setCompoundDrawables(img_on, null, null, null);
						holder.ckDefaultAddr.setTextColor(0xFF0084ff);
						holder.ckDefaultAddr.setText("默认地址");
					}else{
						holder.ckDefaultAddr.setCompoundDrawables(img_off, null, null, null);
						holder.ckDefaultAddr.setTextColor(0xFF555555);
						holder.ckDefaultAddr.setText("设为默认");
					}
			}
		});
         
         return convertView;
     }
}

final class ViewHolder {
    TextView tvName;
    TextView tvPhone;
    TextView tvAdress;
    Button btnEdit;
    Button btnDelete;
    CheckBox ckDefaultAddr;
}
