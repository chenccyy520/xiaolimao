package com.sozunyi.xiaolimao.adapter;

import java.util.List;

import com.sozunyi.xiaolimao.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private Context mContext;
	private String[] mItems = null;
	private int[] mPicID = null;
	
	public MyAdapter(Context context,String[] mItems,int[] mPicID){
		mContext = context;
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
		View view = View.inflate(mContext, R.layout.view_personal_item, null);
		TextView tvItem = (TextView) view.findViewById(R.id.tv_title);
		//ImageView ivItem = (ImageView) view.findViewById(R.id.ivItem);
		//System.out.println(position);
		tvItem.setText(this.mItems[position]);
		//ivItem.setImageResource(this.mPicID[position]);
		return view;
	}

}
