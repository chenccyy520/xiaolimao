package com.sozunyi.xiaolimao.view;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.activity.UpdateAdressActivity;
import com.sozunyi.xiaolimao.entity.CollectionShop;
import com.sozunyi.xiaolimao.view.AdressItemView.ImyCallBack;

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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 店铺收藏
 * @author chen
 *
 */
public class CollectionShopView extends LinearLayout {

	@ViewInject(R.id.tv_collection_shop)
	private TextView mShopName;
	@ViewInject(R.id.tv_phone_shoucang)
	private TextView tvPhone;
	@ViewInject(R.id.tv_locition_shoucang)
	private TextView tvShopAdress;
	
	@ViewInject(R.id.tv_star_mark)
	private TextView tvStar;
	@ViewInject(R.id.tv_weixin_shoucang)
	private TextView tvWeChatNum;
	@ViewInject(R.id.tv_peisong_shoucang)
	private TextView tvDistributionFee;//配送费
	@ViewInject(R.id.tv_yingye_shoucang)
	private TextView tvOpenTime;
	
	@ViewInject(R.id.btn_gonggao)
	private Button btnNotice;//公告
	@ViewInject(R.id.btn_fanwei_shoucang)
	private Button btnRange;//区域
	@ViewInject(R.id.btn_shoucang)
	private Button btnCollection;//收藏
	
	private CollectionShop collectionShop;
	
	public interface ImyCallBack{
		public void onNoticeClick(View v);
		public void onRangeClick(View v);	
		public void onCollectionClick(View v);
	}
	
	 /**  初始化接口变量   */  
    ImyCallBack icallBack = null;  
      
    /** 自定义控件的自定义事件 
     * @param iBack 接口类型 
     */  
    public void setonClick(ImyCallBack iBack)  
    {  
        icallBack = iBack;  
    }  

		
	public CollectionShop getCollectionShop() {
		return collectionShop;
	}

	public void setCollectionShop(CollectionShop collectionShop) {
		this.collectionShop = collectionShop;
	}
	
	
	public CollectionShopView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		initView(context);
	}

	public CollectionShopView(Context context, AttributeSet attrs) {
		super(context, attrs);
 		initView(context);
	}

	public CollectionShopView(Context context) {
		super(context);
		initView(context);
	}
	/**
	 * 
	 */
	private void initView(final Context context){
		View v = View.inflate(getContext(), R.layout.view_item_collection, this);
		ViewUtils.inject(v); //注入VIEW事件
		btnNotice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icallBack.onNoticeClick(v);
			}
		});
		
		btnRange.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icallBack.onRangeClick(v);
			}
		});
		
		btnCollection.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icallBack.onCollectionClick(v);
			}
		});
	}
	
	/**
	 * 设置显示值
	 * @param collectionShop
	 */
	public void setCollectVilue(CollectionShop collectionShop){
		mShopName.setText(collectionShop.getShopName().toString());
		tvPhone.setText(collectionShop.getPhone().toString());
		tvShopAdress.setText(collectionShop.getShopAdress().toString());
		tvWeChatNum.setText(collectionShop.getWeChatNum().toString());
		tvDistributionFee.setText(String.valueOf(collectionShop.getDistributionFee()));
		tvOpenTime.setText(String.valueOf(collectionShop.getOpenTime()).toString());
	}
	
	
}






