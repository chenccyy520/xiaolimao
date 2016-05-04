package com.sozunyi.xiaolimao.view;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.UpdateAdressActivity;
import com.sozunyi.xiaolimao.entity.GoodsInfo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GoodsItemView extends RelativeLayout {

	@ViewInject(R.id.iv_goods_img)
	private ImageView ivImg;
	@ViewInject(R.id.tv_goods_name)
	private TextView tvGoodsName;
	@ViewInject(R.id.tv_goods_count)
	private TextView tvCount;
	@ViewInject(R.id.tv_goods_price)
	private TextView tvPrice;
	private GoodsInfo goodsInfo;
	
	public GoodsItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		initView(context);
	}

	public GoodsItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
 		initView(context);
	}

	public GoodsItemView(Context context) {
		super(context);
		initView(context);
	}
	/**
	 * 
	 */
	private void initView(final Context context){
		View v = View.inflate(getContext(), R.layout.view_item_adress, this);
		ViewUtils.inject(v);
	}

	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	
	public void setGoodsValue(GoodsInfo goodsInfo){
		
	}
	
}






