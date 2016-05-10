package com.sozunyi.xiaolimao.view;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.adapter.MyAdapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ViewLeft extends RelativeLayout{

	private ListView mListView;
	private final String[] items = new String[] { "item1", "item2", "item3", "item4", "item5", "item6" };//显示字段
	private final int[] itemsVaule = new int[] { 1,2,3,4,5,6 };//隐藏id

	private MyAdapter adapter;
	private Context mContext;

	public ViewLeft(Context context) {
		super(context);
		init(context);
	}

	public ViewLeft(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public ViewLeft(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		View v = View.inflate(getContext(), R.layout.view_distance, this);
		mListView = (ListView) v.findViewById(R.id.listView);
		
		adapter = new MyAdapter(mContext, items, itemsVaule);
		mListView.setAdapter(adapter);
		
	}


}
