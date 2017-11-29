package com.partscloud.www.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.partscloud.www.R;


public class ChartFragment extends Fragment implements OnClickListener {
	protected static final String TAG = "ChartFragment";
	private LinearLayout chart_loading;
	private String token;
	private float denstiy;
	private int width;
	private int height;
	private TextView chart_year;
	private TextView chart_mouth;
	private TextView chart_title;
	private RelativeLayout chart_buttons,chart_banners;
//	private ArrayList<UserMonthIn> monthList;
//	private ArrayList<UserYearIn> yearList;
	private TextView chart_lastMonth;
	private TextView chart_nextMonth;
	private String curTime;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.user_chart, container, false);

		return rootView;
	}// monthURLuser_chart.xml

	/**
	 * 获取用户受益信息 年收益
	 *
	 * @author menmen
	 *
	 */
//	class YearTask extends AsyncTask<String, Void, ArrayList<UserYearIn>> {
//		@Override
//		protected void onPreExecute() {
//			chart_loading.setVisibility(View.VISIBLE);
//			user_chart.setVisibility(View.GONE);
//			chart_buttons.setVisibility(View.GONE);
//			super.onPreExecute();
//		}
//
//		@Override
//		protected ArrayList<UserYearIn> doInBackground(String... params) {
//			return UserEngine.getInstance().getYearIn(params[0]);
//		}
//
//		@Override
//		protected void onPostExecute(ArrayList<UserYearIn> result) {
//			super.onPostExecute(result);
//			if (result == null) {
//				chart_loading.setVisibility(View.GONE);
//				LogUtil.showAliert(ChartFragment.this.getActivity(), "信息获取失败！");
//			} else {
//				yearList = result;
//				chart_loading.setVisibility(View.GONE);
//				user_chart.setVisibility(View.VISIBLE);
//				chart_buttons.setVisibility(View.VISIBLE);
//				String month = yearList.get(0).getMonth();
//				String startY = month.substring(0, month.indexOf("/"));
//				String startM = month.substring(month.indexOf("/") + 1,
//						month.lastIndexOf("/"));
//				String last = yearList.get(yearList.size() - 1).getMonth();
//				String endY = last.substring(0, last.indexOf("/"));
//				String endM = last.substring(last.indexOf("/") + 1,
//						last.lastIndexOf("/"));
//				chart_title.setText(startY + "年" + startM + "月至" + endY + "年"
//						+ endM + "月收益");
////				int bannerh=chart_banners.getHeight()+chart_buttons.getHeight();
////				Log.i(TAG, "bannerh:"+bannerh);
////				user_chart.setLayoutParams(new LinearLayout.LayoutParams(width,
////						(int) (height - bannerh)));//TODO:120 * denstiy
//				user_chart
//						.setInfo(null, denstiy, width, height, result);
//				user_chart.invalidate();
//			}
//		}
//	}

	/**
	 * 获取用户受益信息 月收益 params[0]月份,params[1]token
	 * 
	 * @author menmen
	 * 
	 */
//	class MonthTask extends AsyncTask<String, Void, ArrayList<UserMonthIn>> {
//		@Override
//		protected void onPreExecute() {
//			chart_loading.setVisibility(View.VISIBLE);
//			user_chart.setVisibility(View.GONE);
//			chart_buttons.setVisibility(View.GONE);
//			super.onPreExecute();
//		}
//
//		@Override
//		protected ArrayList<UserMonthIn> doInBackground(String... params) {
//			return UserEngine.getInstance().getMonthIn(params[0], params[1]);
//		}
//
//		@Override
//		protected void onPostExecute(ArrayList<UserMonthIn> result) {
//			super.onPostExecute(result);
//			if (result == null) {
//				LogUtil.showAliert(getActivity(),"月收益获取失败，请检查网络！");
//			} else {
//				monthList = result;
//				UserMonthIn monthIn = monthList.get(monthList.size() - 1);
//				curTime = monthIn.getDay();
//				String[] strings = curTime.split("-");
//				chart_title.setText(strings[0]+"年"+strings[1]+"月收益");
//				chart_loading.setVisibility(View.GONE);
//				user_chart.setVisibility(View.VISIBLE);
//				chart_buttons.setVisibility(View.VISIBLE);
//				user_chart
//						.setInfo(null, denstiy, width, height, result);
//				user_chart.invalidate();
//			}
//		}
//	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	@Override
	public void onPause() {
		super.onPause();
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		default:
			break;
		}
	}


	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

}