package com.partscloud.www.utils;

import android.content.Context;
import android.widget.Toast;
public class LogUtil {
	public static void showAliert(Context context,String text) {
//		final AlertDialog builder = new Builder(context).create();
//		builder.show();
//		builder.setCancelable(false);
//		builder.getWindow().setContentView(R.layout.custom_dialog);
//		TextView dialog_text =(TextView) builder.getWindow().findViewById(R.id.dialog_text);
//		dialog_text.setText(text);
//		 builder.getWindow().findViewById(R.id.dialog_button).setOnClickListener(
//				 new OnClickListener() {
//					@Override
//					public void onClick(View v) {
//						builder.dismiss();
//
//					}
//				});
	}
	public static void showToast(Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
	}
	
}
