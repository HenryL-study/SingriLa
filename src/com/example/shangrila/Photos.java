package com.example.shangrila;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;

public class Photos extends Activity {

	private LinearLayout daocheng;
	private LinearLayout yading;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_photos);
		
		daocheng = (LinearLayout)findViewById(R.id.daocheng_photos);
		yading = (LinearLayout)findViewById(R.id.yading_photos);
		
		daocheng.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Photos.this,Daocheng_photos.class);
				startActivity(intent);
			}
		});
		
		yading.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Photos.this,Yading_photos.class);
				startActivity(intent);
			}
		});
	}
}
