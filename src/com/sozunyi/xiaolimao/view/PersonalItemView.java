package com.sozunyi.xiaolimao.view;

import com.sozunyi.xiaolimao.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PersonalItemView extends RelativeLayout {

	TextView tvTitle;
	ImageView ivPhoto;
	private String mTitel;
	
	private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.sozunyi.xiaolimao";
	public PersonalItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		initView();
	}

	public PersonalItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mTitel = attrs.getAttributeValue(NAMESPACE, "title");
		//iconResID = Integer.getInteger(attrs.getAttributeValue(NAMESPACE, "photoResId"));
		initView();
	}

	public PersonalItemView(Context context) {
		super(context);
		initView();
	}
	/**
	 * ��ʼ������
	 */
	private void initView(){
		View v = View.inflate(getContext(), R.layout.view_personal_item, this);
		tvTitle = (TextView) v.findViewById(R.id.tv_title);
		ivPhoto = (ImageView) v.findViewById(R.id.iv_item_photo);
		setTitle(mTitel);
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
	public void setImage(int ResID){
		try{
		ivPhoto.setBackgroundResource(ResID);
		}
		catch (Exception e)
		{
			
		}
	}

}






