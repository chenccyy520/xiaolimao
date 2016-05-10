package com.sozunyi.xiaolimao.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.base.BaseActivity;
import com.sozunyi.xiaolimao.view.ExpandTabView;
import com.sozunyi.xiaolimao.view.ViewLeft;
import com.sozunyi.xiaolimao.view.ViewMiddle;
import com.sozunyi.xiaolimao.view.ViewSimpleList;
import com.sozunyi.xiaolimao.widgets.AutoClearEditText;


public class SearchActivity extends BaseActivity {

	private AutoClearEditText mEditText = null;
	private ImageButton mImageButton = null;
	
	private ExpandTabView expandTabView;
	private ArrayList<View> mViewArray; 
	private ViewLeft viewLeft;
	private ViewMiddle viewMiddle;
	private ViewSimpleList viewRight;
	private ViewSimpleList viewRight1;
	private String[] items = new String[] { "免费配送", "营业中", "配送范围之内"};//显示字段
	private String[] itemsVaule= new String[] { "1", "2", "3" };//隐藏id
	private  int[] itemsIcon = new int[] { R.drawable.mianfei_peisong,
			R.drawable.shaixuan_yingyezhong,R.drawable.shaixuan_fanwei};//图片
	private String[] items1 = new String[] { "离我最近", "最喜欢", "最好"};//显示字段

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		findViewById();
		initVaule();
		initView();
	}

	protected void findViewById() {
		mEditText = (AutoClearEditText) findViewById(R.id.search_edit);
		mImageButton = (ImageButton) findViewById(R.id.search_button);
		expandTabView = (ExpandTabView) findViewById(R.id.expandtab_view);
		mViewArray = new ArrayList<View>();
		viewLeft = new ViewLeft(this);
		viewMiddle = new ViewMiddle(this);
		viewRight = new ViewSimpleList(this,items1,itemsVaule,itemsIcon);
		viewRight1 = new ViewSimpleList(this,items,itemsVaule,itemsIcon);
	}
	
	private void initVaule() {
		
		mViewArray.add(viewLeft);
		mViewArray.add(viewMiddle);
		mViewArray.add(viewRight);
		mViewArray.add(viewRight1);
		ArrayList<String> mTextArray = new ArrayList<String>();
		mTextArray.add("分类");
		mTextArray.add("全城");
		mTextArray.add("排序");
		mTextArray.add("筛选");
		expandTabView.setValue(mTextArray, mViewArray);
		//expandTabView.setTitle(viewLeft.getShowText(), 0);
		//expandTabView.setTitle(viewMiddle.getShowText(), 1);
		//expandTabView.setTitle(viewRight.getShowText(), 2);
		
	}

	protected void initView() {
		mEditText.requestFocus();
		mImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//Auto-generated method stub
				//CommonTools.showShortToast(SearchActivity.this, "亲，该功能暂未开放");
			}
		});
		
		mEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				expandTabView.setVisibility(View.VISIBLE);
			}
		});
	}
}
