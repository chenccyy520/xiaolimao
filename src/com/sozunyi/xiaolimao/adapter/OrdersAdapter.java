package com.sozunyi.xiaolimao.adapter;


import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.sozunyi.xiaolimao.entity.OrdersInfo;
import com.sozunyi.xiaolimao.utils.ToastUtils;
import com.sozunyi.xiaolimao.view.OrdersItemView;
import com.sozunyi.xiaolimao.view.OrdersItemView.ImyCallBack;

public class OrdersAdapter extends MyBaseAdapter<OrdersInfo>  {
	private OrdersInfo ordersInfo;
	 public OrdersAdapter(List lists, Context mContext) {
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
			ordersInfo = lists.get(position);
			OrdersItemView ordersItemView = new OrdersItemView(mContext);
			
			ordersItemView.setGoodsValue(ordersInfo);
			ordersItemView.setonClick(new ImyCallBack() {
				
				@Override
				public void onShopClickButton(View v) {
					ToastUtils.showToast(mContext, "我点击了shop按钮");
				}
				
				@Override
				public void onPayClickButton(View v) {
					ToastUtils.showToast(mContext, "我点击了支付按钮");
				}
				
				@Override
				public void onDeleteClickButton(View v) {
					ToastUtils.showToast(mContext, "我点击了删除按钮");
				}
			});
			
			return ordersItemView;
		}

}
