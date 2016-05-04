package com.sozunyi.xiaolimao.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.sozunyi.xiaolimao.R;
import com.sozunyi.xiaolimao.AppManager;
import com.sozunyi.xiaolimao.fragment.ContentFragment;

public class HomeActivity extends FragmentActivity {

	public static final String TAG = HomeActivity.class.getSimpleName();

	public static final String FRAGMENT_CONTENT = "fragment_content";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AppManager.getInstance().addActivity(this);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		initFragment();
	}

	/**
	 * 初始化fragment, 将fragment数据填充给布局文件
	 */
	private void initFragment() {
		FragmentManager fm = getSupportFragmentManager(); 
		FragmentTransaction transaction = fm.beginTransaction();// 开启事务

		transaction.replace(R.id.fl_content, new ContentFragment());
		transaction.commit();// 提交事务
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return true;
	}
	
	// 获取主页面fragment
	public ContentFragment getContentFragment() {
			FragmentManager fm = getSupportFragmentManager();
			ContentFragment fragment = (ContentFragment) 
					fm.findFragmentByTag(FRAGMENT_CONTENT);

			return fragment;
		}

}
