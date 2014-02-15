package com.kabutomushi.ulsayapps;

import java.util.ArrayList;



import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class UlsayActivity extends Activity {
	
	int mCardId;
	private Button mSayButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.activity_ulsay);
		
		final ListView contentView = (ListView)findViewById(R.id.content);
		mSayButton = (Button)findViewById(R.id.sayButton);
		mSayButton.setVisibility(View.INVISIBLE);
		
		//�j���[�X�f�[�^���(����͉�)
		Bitmap img;
		img = BitmapFactory.decodeResource(getResources(), R.drawable.sample);
		
		ArrayList<NewsCardData> newsData = new ArrayList<NewsCardData>();
		
		NewsCardData item = new NewsCardData();
		item.setTitle("�������A���߂ӂ��̂����ł��B");
		item.setImg(img);
		newsData.add(item);
		
		NewsCardData item1 = new NewsCardData();
		item1.setTitle("��茋�Ԏ��ɂ�铌���h�[���N�z�����C�u");
		item1.setImg(img);
		newsData.add(item1);
		
		NewsCardData item2 = new NewsCardData();
		item2.setTitle("�Y�Y���� ���܂�̃��K�z�����ʂɌ��{");
		item2.setImg(img);
		newsData.add(item2);
		
		NewsCardData item3 = new NewsCardData();
		item3.setTitle("�������A���߂ӂ��̂����ł��B");
		item3.setImg(img);
		newsData.add(item3);
		
		NewsCardData item4 = new NewsCardData();
		item4.setTitle("��茋�Ԏ��ɂ�铌���h�[���N�z�����C�u");
		item4.setImg(img);
		newsData.add(item4);
		
		NewsCardData item5 = new NewsCardData();
		item5.setTitle("�Y�Y���� ���܂�̃��K�z�����ʂɌ��{");
		item5.setImg(img);
		newsData.add(item5);
		//���X�g�ɃA�_�v�^�[���Z�b�g
		NewsCardAdapter adapter = new NewsCardAdapter(this, 0, newsData);
		contentView.setAdapter(adapter);
				
	
		//�L���^�b�v��Say�{�^���\��
		contentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				Log.d("ulsay", "num = " + position);
				mCardId = position;
				mSayButton.setVisibility(View.VISIBLE);
			}
			
		});
		

		contentView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
				mSayButton.setVisibility(View.INVISIBLE);
			}

			@Override
			public void onScrollStateChanged(AbsListView arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.ulsay, menu);
		return true;
	}
	public void onClickSayButton (View view){
		 Toast.makeText(this, "SAY!!!!!num=" + mCardId, Toast.LENGTH_LONG).show();
		mSayButton.setVisibility(View.INVISIBLE);
	}
	

}
