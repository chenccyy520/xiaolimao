package com.sozunyi.xiaolimao.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.entity.GoodsInfo;
import com.sozunyi.xiaolimao.entity.OrdersInfo;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrdersItemView extends LinearLayout {

	private TextView orderTime;//订单时间
	private TextView orderState;//订单状态
	private Button shopName;//店铺名称
	private TextView count;//数量
	private TextView price;//支付金额
	private TextView peiSong;//配送费
	private Button deleteOrder;//删除订单
	private Button payOrder;//支付订单
	private LinearLayout layGoodsInfo;//商品列表
	
	private Context mContext;
	
	private OrdersInfo ordersInfo;
	private List<GoodsInfo> goodsInfos;
	
	/** 定义按钮回调接口 */  
    public interface ImyCallBack{  
        public void onDeleteClickButton(View v);  
        public void onPayClickButton(View v); 
        public void onShopClickButton(View v); 
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
	
	
	public OrdersItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		initView(context);
	}

	public OrdersItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
 		initView(context);
	}

	public OrdersItemView(Context context) {
		super(context);
		initView(context);
	}
	/**
	 * 
	 */
	private void initView(final Context context){
		mContext = context;
		findView(context);	
	}
	
	private void findView(Context context){
		View v = View.inflate(mContext, R.layout.view_item_orders, this);
		orderTime = (TextView) v.findViewById(R.id.tv_orders_time);
		orderState = (TextView) v.findViewById(R.id.tv_order_state);
		shopName = (Button) v.findViewById(R.id.btn_order_shop);
		count = (TextView) v.findViewById(R.id.tv_order_count);
		price = (TextView) v.findViewById(R.id.tv_order_price);
		peiSong = (TextView) v.findViewById(R.id.tv_order_peisong);
		deleteOrder = (Button) v.findViewById(R.id.btn_order_delete);
		payOrder = (Button) v.findViewById(R.id.btn_order_pay);
		layGoodsInfo = (LinearLayout) v.findViewById(R.id.lay_orders_goods);
		onClickListener();
	}
	
	private void onClickListener(){
		shopName.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icallBack.onShopClickButton(v);
			}
		});
		
		deleteOrder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icallBack.onDeleteClickButton(v);
			}
		});
		
		payOrder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icallBack.onPayClickButton(v);
			}
		});
	}
	
	/**
	 * 设置订单显示值
	 * @param 
	 */
	public void setGoodsValue(OrdersInfo Info){
		this.ordersInfo = Info;
		orderTime.setText(orderDate(ordersInfo.getOrderDate()));
		
		orderState.setText(setOrderState(ordersInfo.getOrderStates()));
		shopName.setText(ordersInfo.getShopName());
		count.setText("共 "+ordersInfo.getCount()+" 份，合计：￥");
		price.setText(String.valueOf(ordersInfo.getTotalPrice()));
		peiSong.setText("（含配送费￥"+ordersInfo.getCarriage()+"）");
		
		goodsInfos = ordersInfo.getListGoods();
		for(GoodsInfo info : goodsInfos){//循环添加订单中的商品信息
			GoodsItemView goodsItemView = new GoodsItemView(getContext());
			goodsItemView.setGoodsValue(info);
			layGoodsInfo.addView(goodsItemView);
		}
	}
	
	/**
	 * 返回日期
	 * @param state
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	private String orderDate(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	
	/**
	 * 返回订单状态
	 * @param state
	 * @return
	 */
	private String setOrderState(int state){
		String mState = "";
		switch(state){
			case 0: mState="等待付款"; break;
			case 1: mState="等待发货"; break;
			case 2: mState="等待收货"; break;
			case 3: mState="交易完成"; break;
			default:break;
		}
		return mState;
	}

	public OrdersInfo getOrdersInfo() {
		return ordersInfo;
	}

	public void setOrdersInfo(OrdersInfo ordersInfo) {
		this.ordersInfo = ordersInfo;
	}
	
}






