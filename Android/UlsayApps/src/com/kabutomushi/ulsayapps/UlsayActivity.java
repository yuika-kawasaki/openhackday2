package com.kabutomushi.ulsayapps;

import java.util.ArrayList;



import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

public class UlsayActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.activity_ulsay);
		
		final ListView contentView = (ListView)findViewById(R.id.content);
		
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
		
		//���X�g�ɃA�_�v�^�[���Z�b�g
		NewsCardAdapter adapter = new NewsCardAdapter(this, 0, newsData);
		contentView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.ulsay, menu);
		return true;
	}
	public void onClickSayButton (View view){
		 Toast.makeText(this, "SAY!!!!!", Toast.LENGTH_LONG).show();
	}

}
