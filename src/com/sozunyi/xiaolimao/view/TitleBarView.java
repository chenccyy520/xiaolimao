package com.sozunyi.xiaolimao.view;

import com.sozunyi.xiaolimao.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TitleBarView extends RelativeLayout {

	TextView tvTitle;
	Button btnBack;
	Context mContext;
	
	private String mTitel;
	
	private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.sozunyi.xiaolimao";
	public TitleBarView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		initView();
	}

	public TitleBarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mTitel = attrs.getAttributeValue(NAMESPACE, "title");
		mContext = context;
		initView();
	}

	public TitleBarView(Context context) {
		super(context);
		mContext = context;
		initView();
	}
	/**
	 * 初始化数据
	 */
	private void initView(){
		View v = View.inflate(getContext(), R.layout.view_item_titlebar, this);
		tvTitle = (TextView) v.findViewById(R.id.tv_title_bar);
		btnBack = (Button) v.findViewById(R.id.btn_title_back);
		setTitle(mTitel);
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//onKeyDown(KeyEvent.KEYCODE_BACK, null); 
				//Toast.makeText(mContext, "我点击了返回按钮", Toast.LENGTH_SHORT).show();
				((Activity)mContext).finish();//结束上下文ACTIVITY
			}
		});
	}
	
	/**
	 * 标题
	 * @param title
	 */
	public void setTitle(String title)
	{
		tvTitle.setText(title);
	}

}






