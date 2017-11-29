package com.partscloud.www.fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.partscloud.www.R;
import com.partscloud.www.utils.LogUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeFragment extends Fragment {
	private static final String TAG = "HomeFragment";

	private ExecutorService homeThreads=null;

	public HomeFragment() {
	}

	Handler homeHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 2:// 刷新成功
					setHomeAdapter();
					Log.i(TAG, "onRefresh seccess!");
				break;
			case 3:// 刷新失败
				LogUtil.showAliert(getActivity(), "没有获取到信息，请检查网络！");
				break;
			default:
				break;
			}
		};
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.home_fragment, container,
				false);
		// 下拉刷新
//		home_refresh_view = (RefreshListview) rootView
//				.findViewById(R.id.home_refresh_view);
//		home_list_view = (ListView) rootView.findViewById(R.id.home_list_view);
//
//		home_loading = (LinearLayout) rootView.findViewById(R.id.home_loading);
//		home_loading.setVisibility(View.VISIBLE);
//
//		if(homeThreads==null&&imageList==null){
//			if(!NetUtil.checkNetState(getActivity())){
//				LogUtil.showToast(getActivity(),"网络未连接！");
//			}
//			homeThreads = Executors.newFixedThreadPool(3);
//			homeThreads.execute(new Runnable() {
//				@Override
//				public void run() {
//					imageList = HomeEngine.getInstance().getImageList(
//							HomeFragment.this.getActivity());
//					idanbaoList = HomeEngine.getInstance().getIdanbaoMainList(
//							HomeFragment.this.getActivity());
//					getActivity().runOnUiThread(new Runnable() {
//						public void run() {
//							home_loading.setVisibility(View.GONE);
//							if (imageList != null && idanbaoList != null) {
//								setHomeAdapter();
//							} else {
//								LogUtil.showAliert(getActivity(), "没有获取到信息，请检查网络！");
//							}
//						}
//					});
//				}
//			});
//		}else {
//			home_loading.setVisibility(View.GONE);
//			if (homeAdapter == null) {
//				homeAdapter = new HomeAdapter(
//						getActivity(), imageList,
//						idanbaoList);
//			}
//				home_list_view.setAdapter(homeAdapter);
//				home_list_view.invalidate();
//		}
//		home_refresh_view.setOnRefreshListener(new PullToRefreshListener() {
//
//			@Override
//			public void onRefresh() {
//				imageList = HomeEngine.getInstance().
//						getImageList(HomeFragment.this.getActivity());
//				idanbaoList = HomeEngine.getInstance().
//						getIdanbaoMainList(HomeFragment.this.getActivity());
//				if (imageList != null && idanbaoList != null) {
//					homeHandler.sendEmptyMessage(2);
//				} else {
//					homeHandler.sendEmptyMessage(3);
//				}
//			}
//		}, 0);
		return rootView;
	}
	protected void setHomeAdapter() {
//		if(imageList!=null){
//			for (HomeImageMap imageMap : imageList) {
//				ImageLoader.getInstance(getActivity())
//				.downLoadBitmap(imageMap.getImgUrl());
//			}
//		}
//		if (homeAdapter == null) {
//			homeAdapter = new HomeAdapter(
//					getActivity(), imageList,
//					idanbaoList);
//			home_list_view.setAdapter(homeAdapter);
//		} else {
//			homeAdapter.notifyDataSetChanged();
//			home_list_view.invalidate();
//		}
	}
	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
		getActivity().setRequestedOrientation(
				ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {
		// 保存数据
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroy() {
		if(homeThreads!=null)
			homeThreads.shutdown();
//		ImageLoader.getInstance(getActivity()).shutThreads();
		super.onDestroy();
	}
}
