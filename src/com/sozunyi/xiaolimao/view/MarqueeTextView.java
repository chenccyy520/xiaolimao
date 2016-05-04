package com.sozunyi.xiaolimao.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeTextView extends TextView implements Runnable {
	
	private int currentScrollX;// 当前滚动的位置 
	private boolean isStop = false; 
	private int textWidth; 
	private boolean isMeasure = false; 
	
	
	//用代码NEW对象是走此方法
	public MarqueeTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	//有属性是走此方法
	public MarqueeTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	//有STYLE样式是走此方法
	public MarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
	}
	
	@Override 
	protected void onDraw(Canvas canvas) { 
		// TODO Auto-generated method stub 
		super.onDraw(canvas); 
			if (!isMeasure) {// 文字宽度只需获取一次就可以了 
			getTextWidth(); 
			isMeasure = true; 
			} 
	} 
	/** 
	* 获取文字宽度 
	*/ 
	private void getTextWidth() { 
		Paint paint = this.getPaint(); 
		String str = this.getText().toString(); 
		textWidth = (int) paint.measureText(str); 
	} 
	
	@Override 
	public void run() { 
		currentScrollX -= 2;// 滚动速度 
		scrollTo(currentScrollX, 0); 
		if (isStop) { 
		return; 
		} 
	if (getScrollX() <= -(this.getWidth())) { 
		scrollTo(textWidth, 0); 
		currentScrollX = textWidth; 
		// return; 
		} 
		postDelayed(this, 5); 
	} 
	
	// 开始滚动 
	public void startScroll() { 
		isStop = false; 
		this.removeCallbacks(this); 
		post(this); 
	} 
	
	// 停止滚动 
	public void stopScroll() { 
		isStop = true; 
	} 
	
	// 从头开始滚动 
	public void startFor0() { 
		currentScrollX = 0; 
		startScroll(); 
	} 
	
	/**
	 * 表示有没有焦点都让控件获取焦点，走跑马灯效果都返回TRUE
	 */
	@Override
	public boolean isFocused() {
		return true;
	}

}
