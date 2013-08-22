package com.example.imageswitch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	//初始化图像显示的id
	private int[] imgId = new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03};
	//当前显示图像的索引
	private int index = 0;
	private ImageSwitcher imgSwitch = null;
	private ImageView imageView = null;
	private Button up = null;
	private Button down = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imgSwitch = (ImageSwitcher)findViewById(R.id.imageSwitcher1);
		up = (Button)findViewById(R.id.button1);
		down = (Button)findViewById(R.id.button2);
		//设置动画效果
		//效果为淡入
		imgSwitch.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
		//设置为淡出
		imgSwitch.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
		/**
		 * 
		 * 此处是重点，如何将图片显示出来
		 * 
		 * */
		imgSwitch.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				imageView = new ImageView(MainActivity.this);
				//设置保持纵横比居中的缩放图像
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				return imageView;
			}
		});
		//显示默认的图片
		imgSwitch.setImageResource(imgId[index]);
		up.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (index > 0) {
					index--;
				} else {
					index = imgId.length - 1;
				}
				imgSwitch.setImageResource(imgId[index]);
			}
		});
		down.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (index < imgId.length - 1) {
					index++;
				} else {
					index = 0;
				}
				imgSwitch.setImageResource(imgId[index]);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
