package com.partscloud.www;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.partscloud.www.utils.FileUtil;


public class SplashActivity extends Activity {
	private static final String TAG = "SplashActivity";
	private boolean FIRST_IMAGE = true;
	private RelativeLayout splash_views;
	private GestureDetector mGesture;
	private static ArrayList<ImageView> splashs = new ArrayList<ImageView>();
	private static int currentID = 0;
	private LayoutParams lp;

	// 1.播放splash
	// 2.预加载数据TODO:
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//根据存储的字段 判断是否是第一次登录
		if (!FileUtil.isFirst(this)) {
			startMainActivity();
		} else {
			FileUtil.saveFirst(this);
			setContentView(R.layout.splash_home);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}


	private void startMainActivity() {
		Intent intent = new Intent(SplashActivity.this, MainActivity.class);
		startActivity(intent);
		finish();
	}

}