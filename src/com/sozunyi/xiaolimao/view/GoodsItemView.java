package com.sozunyi.xiaolimao.view;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.entity.GoodsInfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * 商品布局自定义控件
 * @author chen
 *
 */
public class GoodsItemView extends RelativeLayout {

	private ImageView ivImg;
	private TextView tvGoodsName;
	private TextView tvCount;
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
	 * 初始化布局
	 */
	private void initView(final Context context){
		View v = View.inflate(getContext(), R.layout.view_item_goods, this);
		findView(v);
	}
	
	private void findView(View v){
		ivImg = (ImageView) v.findViewById(R.id.iv_goods_img);
		tvGoodsName = (TextView) v.findViewById(R.id.tv_goods_name);
		tvCount = (TextView) v.findViewById(R.id.tv_goods_count);
		tvPrice = (TextView) v.findViewById(R.id.tv_goods_price);
	}

	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	
	/**
	 * 设置基本显示数据
	 * @param goodsInfo
	 */
	public void setGoodsValue(GoodsInfo goodsInfo){
		this.goodsInfo = goodsInfo;
		tvGoodsName.setText(goodsInfo.getGoodsName());
		tvCount.setText("X "+String.valueOf(goodsInfo.getCount()));
		tvPrice.setText("￥"+String.valueOf(goodsInfo.getPrice()));
	}
	
}






