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

	//��ʼ��ͼ����ʾ��id
	private int[] imgId = new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03};
	//��ǰ��ʾͼ�������
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
		//���ö���Ч��
		//Ч��Ϊ����
		imgSwitch.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
		//����Ϊ����
		imgSwitch.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
		/**
		 * 
		 * �˴����ص㣬��ν�ͼƬ��ʾ����
		 * 
		 * */
		imgSwitch.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				imageView = new ImageView(MainActivity.this);
				//���ñ����ݺ�Ⱦ��е�����ͼ��
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				return imageView;
			}
		});
		//��ʾĬ�ϵ�ͼƬ
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
