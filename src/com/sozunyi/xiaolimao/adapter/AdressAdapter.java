package com.sozunyi.xiaolimao.adapter;

import java.util.List;

import com.sozunyi.xiaolimao.entity.AdressInfo;
import com.sozunyi.xiaolimao.utils.ToastUtils;
import com.sozunyi.xiaolimao.view.AdressItemView;
import com.sozunyi.xiaolimao.view.AdressItemView.ImyCallBack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

public class AdressAdapter extends MyBaseAdapter<AdressInfo>  {
	 private AdressInfo adressInfo;
	 public AdressAdapter(List lists, Context mContext) {
         super(lists, mContext);
     }
	
	 @Override
		public int getCount() {
			return lists.size();
		}
		@Override
		public Object getItem(int position) {
			return null;
		}
		@Override
		public long getItemId(int position) {
			return 0;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			adressInfo = lists.get(position);
			final AdressItemView adressItemView = new AdressItemView(mContext);
			
			adressItemView.setAdressInfo(adressInfo);
			adressItemView.setonClick(new ImyCallBack() {
				
				@Override
				public void onEditClick(View v) {
					ToastUtils.showToast(mContext, "我点击了编辑按钮");
				}
				
				@Override
				public void onDeleteClick(View v) {
					ToastUtils.showToast(mContext, "我点击了删除按钮");
				}
				
				@Override
				public void onDefaultCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					adressItemView.setDefaultAdressCleck(isChecked);
				}
			});
						
			return adressItemView;
		}

}

