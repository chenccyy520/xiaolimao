package com.sozunyi.xiaolimao.view;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.adapter.MyArrayAdapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class ViewSimpleList extends RelativeLayout implements ViewBaseAction{

	private ListView mListView;
	private String[] items;// = new String[] { "免费配送", "营业中", "配送范围之内"};//显示字段
	private String[] itemsVaule;// = new String[] { "1", "2", "3" };//隐藏id
	private  int[] itemsIcon;// = new int[] { R.drawable.mianfei_peisong,
			//R.drawable.shaixuan_yingyezhong,R.drawable.shaixuan_fanwei};//图片
	private OnSelectListener mOnSelectListener;
	private MyArrayAdapter adapter;
	private String mDistance;
	private String showText = "免费配送";
	private Context mContext;

	public String getShowText() {
		return showText;
	}

	public ViewSimpleList(Context context,String[] items,String[] itemsVaule,int[] itemsIcon) {
		super(context);
		this.items = items;
		this.itemsVaule = itemsVaule;
		this.itemsIcon = itemsIcon;
		
		init(context);
	}

	public ViewSimpleList(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public ViewSimpleList(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}
	
	

	private void init(Context context) {
		mContext = context;
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.view_distance, this, true);
		//setBackgroundDrawable(getResources().getDrawable(R.drawable.choosearea_bg_right));
		v.setBackgroundColor(0xffffffff);//白色
		mListView = (ListView) v.findViewById(R.id.listView);
		adapter = new MyArrayAdapter(context, items,itemsIcon, R.drawable.choose_item_right, R.drawable.choose_eara_item_selector);
		adapter.setTextSize(17);
		if (mDistance != null) {
			for (int i = 0; i < itemsVaule.length; i++) {
				if (itemsVaule[i].equals(mDistance)) {
					adapter.setSelectedPositionNoNotify(i);
					showText = items[i];
					break;
				}
			}
		}
		mListView.setAdapter(adapter);
		adapter.setOnItemClickListener(new MyArrayAdapter.OnItemClickListener() {

			@Override
			public void onItemClick(View view, int position) {

				if (mOnSelectListener != null) {
					showText = items[position];
					mOnSelectListener.getValue(itemsVaule[position], items[position]);
				}
			}
		});
	}

	public void setOnSelectListener(OnSelectListener onSelectListener) {
		mOnSelectListener = onSelectListener;
	}

	public interface OnSelectListener {
		public void getValue(String distance, String showText);
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void show() {
		
	}

}
