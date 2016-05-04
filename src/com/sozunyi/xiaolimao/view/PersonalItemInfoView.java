package com.sozunyi.xiaolimao.view;

import com.sozunyi.xiaolimao.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PersonalItemInfoView extends RelativeLayout {

	TextView tvTitle;
	TextView tvValue;
	Button btnUpdate;
	
	private String mTitel;
	private String mValue;
	
	private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.sozunyi.xiaolimao";
	public PersonalItemInfoView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		initView();
	}

	public PersonalItemInfoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mTitel = attrs.getAttributeValue(NAMESPACE, "title");
		mValue = attrs.getAttributeValue(NAMESPACE, "value");
		//iconResID = Integer.getInteger(attrs.getAttributeValue(NAMESPACE, "photoResId"));
		initView();
	}

	public PersonalItemInfoView(Context context) {
		super(context);
		initView();
	}
	/**
	 * ��ʼ������
	 */
	private void initView(){
		View v = View.inflate(getContext(), R.layout.view_personal_item_info, this);
		tvTitle = (TextView) v.findViewById(R.id.iv_item_name);
		tvValue = (TextView) v.findViewById(R.id.tv_item_value);
		setTitle(mTitel);
		setDisplayValue(mValue);
	}
	
	/**
	 * 标题
	 * @param title
	 */
	public void setTitle(String title)
	{
		tvTitle.setText(title);
	}
	
	/**
	 * 设置ICON
	 * @param ResID
	 */
	public void setDisplayValue(String value){
		tvValue.setText(value);
	}

}






