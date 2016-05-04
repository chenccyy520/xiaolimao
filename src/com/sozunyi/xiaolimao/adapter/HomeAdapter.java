package com.sozunyi.xiaolimao.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sozunyi.xiaolimao.R;

/**
 * 添加商品的图标以及技能图标
 * @author chen
 *
 */
@SuppressLint("ViewHolder")
public  class HomeAdapter extends BaseAdapter{

	private Activity mActivity;
	private String[] mItems = null;
	private int[] mPicID = null;
	
	public HomeAdapter(Activity activity,String[] mItems,int[] mPicID){
		mActivity = activity;
		this.mItems = mItems;
		this.mPicID = mPicID;
	}
	
	@Override
	public int getCount() {
		return mItems.length;
	}

	@Override
	public Object getItem(int position) {
		return mItems[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = View.inflate(mActivity, R.layout.home_list_item, null);
		TextView tvItem = (TextView) view.findViewById(R.id.tvItem);
		ImageView ivItem = (ImageView) view.findViewById(R.id.ivItem);
		//System.out.println(position);
		tvItem.setText(this.mItems[position]);
		ivItem.setImageResource(this.mPicID[position]);
		return view;
	}
}
