package com.partscloud.www.fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.partscloud.www.R;
import com.partscloud.www.RegisterActivity;
import com.partscloud.www.utils.DeviceInfoUtil;
import com.partscloud.www.utils.FileUtil;
import java.util.concurrent.ExecutorService;

public class UserFragment extends Fragment implements OnClickListener {

	protected static final String TAG = "UserFragment";
	private TextView use_iremain, total_imoney, income_mouth, income_year,
			income_sum,income_rmb;
	private RelativeLayout income_totals, income_remains;
	private LinearLayout user_loading;
	private LinearLayout user_views;
	private String token;
	private ExecutorService userThreads=null;
	private View root;
	private int height;
	private int width;
	private float denstiy;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "fragment onCreateView!");
		if(FileUtil.getToken(getActivity())==null){
			Intent register = new Intent(getActivity(),
					RegisterActivity.class);
			startActivity(register);
			return null;
		}else{
			DisplayMetrics dm = DeviceInfoUtil.getMetrics(getActivity());
			denstiy = dm.density;
			height = dm.heightPixels;
			width = dm.widthPixels;
			Log.i(TAG, "denstiy:" + denstiy + "height:" + height + "width:" + width);
			root = inflater.inflate(R.layout.user_fragment, container, false);
			income_remains = (RelativeLayout) root.findViewById(R.id.income_remains);
			income_totals = (RelativeLayout) root.findViewById(R.id.income_totals);
			user_loading = (LinearLayout) root.findViewById(R.id.user_loading);
			user_loading.setLayoutParams(new LinearLayout.LayoutParams(width, height-50*(int)denstiy));
			user_views = (LinearLayout) root.findViewById(R.id.user_views);
			income_sum = (TextView) root.findViewById(R.id.income_sum);
			income_rmb = (TextView) root.findViewById(R.id.income_rmb);
			income_year = (TextView) root.findViewById(R.id.income_year);
			income_mouth = (TextView) root.findViewById(R.id.income_mouth);
			use_iremain = (TextView) root.findViewById(R.id.use_iremain);
			total_imoney = (TextView) root.findViewById(R.id.total_imoney);
//			if(!NetUtil.checkNetState(getActivity())){
//				LogUtil.showAliert(getActivity(), "网络未连接！");
//			}else{
//				getActivity().setRequestedOrientation(
//						ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
//				income_remains.setOnClickListener(this);
//				income_totals.setOnClickListener(this);
//				income_year.setOnClickListener(this);
//				income_mouth.setOnClickListener(this);
//				yearData();
//			}
			return root;
		}
	}

//	protected void initChartView(ArrayList<? extends Object> incomeList) {
//		income_chart = (ChartView) root.findViewById(R.id.income_chart);
//		income_chart.setLayoutParams(new LinearLayout.LayoutParams(
//				width, (int) (height / 2 - 120 * denstiy)));
//		income_chart.setInfo(pHandler, denstiy, width, height / 2,
//				incomeList);
//		income_chart.setVisibility(View.VISIBLE);
//		income_chart.invalidate();
//		Log.i(TAG, "income_chart:" + "  setInfo!");
//	}

//	private void yearData() {
//		showLoading();
//		token = FileUtil.getToken(getActivity());
//		if(userThreads==null)
//		userThreads = Executors.newFixedThreadPool(3);
//		userThreads.execute(new Runnable() {
//			@Override
//			public void run() {
//				UserEngine.getInstance().userIndex(pHandler, token);
//			}
//		});
//	}
	@Override
	public void onResume() {
		super.onResume();
		if(FileUtil.getToken(getActivity())==null){
			Intent register = new Intent(getActivity(),
					RegisterActivity.class);
			startActivity(register);
		}
//		MobclickAgent.onPageStart(TAG);
	}
	@Override
	public void onPause() {
		super.onPause();
//		MobclickAgent.onPageEnd(TAG);
	}
	@Override
	public void onDestroy() {
		if (userThreads != null)
			userThreads.shutdown();
		super.onDestroy();
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		default:
			break;
		}
	}
	}


