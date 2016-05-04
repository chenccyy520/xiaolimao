package com.sozunyi.xiaolimao.view;

import com.sozunyi.xiaolimao.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PersonalLoginView extends RelativeLayout {

	TextView tvTitle;
	TextView tvDesc;
	ImageView ivPhoto;
	private String mTitel;
	private String mDesc;
	
	private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.sozunyi.xiaolimao";
	public PersonalLoginView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		initView();
	}

	public PersonalLoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mTitel = attrs.getAttributeValue(NAMESPACE, "title");//�����������ƻ�ȡ���Ե�ֵ
		mDesc = attrs.getAttributeValue(NAMESPACE, "desc");
		//userPhotoResID = Integer.getInteger(attrs.getAttributeValue(NAMESPACE, "photoResId"));
		initView();
	}

	public PersonalLoginView(Context context) {
		super(context);
		initView();
	}
	/**
	 * ��ʼ������
	 */
	private void initView(){
		//���Զ���õĲ����ļ����ø���ǰ��SettingItemView
		View v = View.inflate(getContext(), R.layout.view_personal_item_login, this);
		tvTitle = (TextView) v.findViewById(R.id.tv_title_img);
		tvDesc = (TextView) v.findViewById(R.id.tv_desc_img);
		ivPhoto = (ImageView) v.findViewById(R.id.iv_personal_photo);
		setTitle(mTitel);
		setDesc(mDesc);
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
	 * 信息
	 * @param desc
	 */
	public void setDesc(String desc)
	{
		tvDesc.setText(desc);
	}
	
	/**
	 * 设置头像
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






