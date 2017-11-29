package com.partscloud.www.fragment;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.util.LruCache;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.partscloud.www.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ProjectFragment extends Fragment implements OnClickListener {
	protected static final String TAG = "ProjectFragment";
//	private View idanbao_list, irongzu_list;
//	private TextView idanbao_title, irongzu_title;
//	private LinearLayout project_idanbao_loading, project_irongzu_loading;
//	private ViewPager project_viewpager;
//	private ArrayList<View> pageViewList = new ArrayList<View>();
//	private int currIndex = 0;// 当前页卡编号
//	private ListView danbao_list_view, rongzu_list_view;
//	private RefreshListview project_idanbao_refresh, project_irongzu_refresh;
//	private ArrayList<IdanbaoMain> idanbaoMainList, idanbaMainList2;
//	private IdanbaoAdapter idanbaoAdapter = null;
//	private IdanbaoAdapter2 idanbaoAdapter2 = null;
//	private LruCache<Integer, ArrayList<IdanbaoMain>> idanbaoCache=null,
//			irongzuCache=null;

	/**
	 * 当前拉取的页数
	 */
	public static Integer IDANBAO_P = 0, IRONGZU_P = 0;
	/**
	 * 丢失需要重新加载的页面，当lrucache中的某页数据被回收了，重新加载这个页面数据
	 */
	public static Integer IDANBAO_CP=0,IRONGZU_CP=0;
	/**
	 * 每页的ArrayList<IdanbaoMain>大小 (不是最后一页!)
	 */
	public static int IDANBAO_S = 0, IRONGZU_S = 0;
	/**
	 * 最后一页的ArrayList<IdanbaoMain>大小 (如果它不是IDANBAO_S)
	 */
	public static int IDANBAO_L = 0, IRONGZU_L;
	/**
	 * 当前Listview显示的item position
	 */
	public static int position1 = 0, position2=0;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "fragment onCreateView!");
		View rootView = inflater.inflate(R.layout.project_fragment, container,
				false);
		return  rootView;
	}

	@Override
	public void onResume() {
		super.onResume(); 
		getActivity().setRequestedOrientation(
				ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//		MobclickAgent.onPageStart(TAG);
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
//		MobclickAgent.onPageEnd(TAG);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
//		if(null!=idanbaoAdapter)idanbaoAdapter.shutThreads();
//		if(null!=idanbaoAdapter2)idanbaoAdapter2.shutThreads();
	}

	@Override
	public void onClick(View v) {

	}
}
