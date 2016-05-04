package com.sozunyi.xiaolimao.baidu;

import com.baidu.mapapi.SDKInitializer;
import com.sozunyi.xiaolimao.BaseApplication;
import com.sozunyi.xiaolimao.service.LocationService;

import android.app.Service;
import android.os.Vibrator;

/**
 * 主Application，所有百度定位SDK的接口说明请参考线上文档：http://developer.baidu.com/map/loc_refer/index.html
 *
 * 百度定位SDK官方网站：http://developer.baidu.com/map/index.php?title=android-locsdk
 * 
 * 直接拷贝com.baidu.location.service包到自己的工程下，简单配置即可获取定位结果，也可以根据demo内容自行封装
 */
public class LocationApplication extends BaseApplication {
	public static LocationService locationService;
    public Vibrator mVibrator;
    @Override
    public void onCreate() {
        super.onCreate();
        /***
         * 初始化定位sdk，建议在Application中创建
         */
        locationService = new LocationService(getApplicationContext());
        System.out.println(locationService.toString());
        System.out.println("我已经初始化");
        
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());  
       
    }
}
