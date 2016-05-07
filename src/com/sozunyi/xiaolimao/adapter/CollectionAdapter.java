package com.sozunyi.xiaolimao.adapter;

import java.util.List;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.entity.AdressInfo;
import com.sozunyi.xiaolimao.entity.CollectionShop;
import com.sozunyi.xiaolimao.utils.ToastUtils;
import com.sozunyi.xiaolimao.view.CollectionShopView;
import com.sozunyi.xiaolimao.view.CollectionShopView.ImyCallBack;

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

public class CollectionAdapter extends MyBaseAdapter<CollectionShop>  {
	 private CollectionShop collectionShop;
	 public CollectionAdapter(List lists, Context mContext) {
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
			collectionShop = lists.get(position);
			final CollectionShopView collectionShopView = new CollectionShopView(mContext);
			
			collectionShopView.setCollectVilue(collectionShop);
			collectionShopView.setonClick(new ImyCallBack() {
				
				@Override
				public void onRangeClick(View v) {
					ToastUtils.showToast(mContext, "我点击了区域按钮");
				}
				
				@Override
				public void onNoticeClick(View v) {
					ToastUtils.showToast(mContext, "我点击了通知按钮");
				}

				@Override
				public void onCollectionClick(View v) {
					ToastUtils.showToast(mContext, "我点击了收藏按钮");
				}
			});
			
			return collectionShopView;
		}

}

