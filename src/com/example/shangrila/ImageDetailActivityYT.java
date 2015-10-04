package com.example.shangrila;

import java.io.File;

import com.example.shangrila.ImageDetailsActivityDC.ViewPagerAdapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import bitmaputil.Images;
import bitmaputil.ZoomImageView;

public class ImageDetailActivityYT extends Activity implements OnPageChangeListener{

	/** 
     * 用于管理图片的滑动 
     */  
    private ViewPager viewPager;  
  
    /** 
     * 显示当前图片的页数 
     */  
    private TextView pageText; 
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.activity_image_detail_yt);  
        int imagePosition = getIntent().getIntExtra("image_position", 0);
        pageText = (TextView)findViewById(R.id.page_textyt);
        viewPager = (ViewPager) findViewById(R.id.view_pageryt);
        ViewPagerAdapter adapter = new ViewPagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(imagePosition);  
        viewPager.setOnPageChangeListener(this);
        // 设定当前的页数和总页数  
        // 还没有写判断
        pageText.setText((imagePosition + 1) + "/" + Images.imageUrlsyt.length);
    }

    /** 
     * ViewPager的适配器 
     *  
     * @author guolin 
     */  
    class ViewPagerAdapter extends PagerAdapter {  
  
        @Override  
        public Object instantiateItem(ViewGroup container, int position) {  
            String imagePath = getImagePath(Images.imageUrlsyt[position]);  
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);  
            if (bitmap == null) {  
                bitmap = BitmapFactory.decodeResource(getResources(),  
                        R.drawable.empty_photo);  
            }  
            View view = LayoutInflater.from(ImageDetailActivityYT.this).inflate(R.layout.zoom_image_layout, null);  
            ZoomImageView zoomImageView = (ZoomImageView) view  
                    .findViewById(R.id.zoom_image_view);  
            zoomImageView.setImageBitmap(bitmap);  
            container.addView(view);  
            return view;  
        }  
  
        @Override  
        public int getCount() {  
            return Images.imageUrlsyt.length;  
        }  
  
        @Override  
        public boolean isViewFromObject(View arg0, Object arg1) {  
            return arg0 == arg1;  
        }  
  
        @Override  
        public void destroyItem(ViewGroup container, int position, Object object) {  
            View view = (View) object;  
            container.removeView(view);  
        }  
  
    }
    
    /** 
     * 获取图片的本地存储路径。 
     *  
     * @param imageUrl 
     *            图片的URL地址。 
     * @return 图片的本地存储路径。 
     */  
    private String getImagePath(String imageUrl) {  
        int lastSlashIndex = imageUrl.lastIndexOf("/");  
        String imageName = imageUrl.substring(lastSlashIndex + 1);  
        String imageDir = Environment.getExternalStorageDirectory().getPath()  
                + "/ShangriLaYT/";
        File file = new File(imageDir);  
        if (!file.exists()) {  
            file.mkdirs();  
        }  
        String imagePath = imageDir + imageName;  
        return imagePath;  
    }
    
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int currentPage) {
		// TODO Auto-generated method stub
		// 每当页数发生改变时重新设定一遍当前的页数和总页数  
        pageText.setText((currentPage + 1) + "/" + Images.imageUrlsyt.length);
	}
}
