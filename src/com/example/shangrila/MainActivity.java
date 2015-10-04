package com.example.shangrila;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import bitmaputil.bitmaputils;

public class MainActivity extends Activity {

	private LinearLayout appback;
	private GridView gridView;
	private int[] imageIds = new int[]{
			R.drawable.brief_introduction, R.drawable.slight,
			R.drawable.house, R.drawable.bus,
			R.drawable.delicious, R.drawable.shopping,
			R.drawable.tips, R.drawable.photos
	};
	private String[] title = new String[]{
			"简介", "景点", "行程与住宿", "交通",
			"美食", "购物", "Tips", "美图"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		/**
		 * 初始化背景图
		 */
		appback = (LinearLayout)findViewById(R.id.app_background);
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		int StatusBarHeight = bitmaputils.getStatusBarHeight(this);
		height -= StatusBarHeight;
		Drawable db = new BitmapDrawable
				(getResources(),bitmaputils.decodeSampledBitmapFromResource(getResources(), R.drawable.background, width, height));
	    appback.setBackground(db);
		/**
		 * 设置菜单
		 */
		gridView = (GridView)findViewById(R.id.first_page);
		List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < title.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("icon", imageIds[i]);
			listItem.put("title", title[i]);
			listItems.add(listItem);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, 
				R.layout.grid_icon, 
				new String[] {"icon", "title"}, 
				new int[] {R.id.introduce_icon, R.id.introduction});
		gridView.setAdapter(simpleAdapter);
		/**
		 * 设置点击按钮
		 */
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					Intent intent0 = new Intent(MainActivity.this,BriefActivity.class);
					startActivity(intent0);
					break;
				case 7:
					Intent intent7 = new Intent(MainActivity.this,Photos.class);
					startActivity(intent7);
					break;

				default:
					break;
				}
			}
		});
	}
}













