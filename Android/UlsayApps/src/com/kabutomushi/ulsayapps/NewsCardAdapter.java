package com.kabutomushi.ulsayapps;

import java.util.List;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewsCardAdapter extends ArrayAdapter<NewsCardData> {
	private LayoutInflater layoutInflater;

	public NewsCardAdapter(Context context, int textViewResourceId,
			List<NewsCardData> objects) {
		super(context, textViewResourceId, objects);
		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// ����̍s(position)�̃f�[�^�𓾂�
		NewsCardData item = (NewsCardData) getItem(position);

		// convertView�͎g���񂵂���Ă���\��������̂�null�̎������V�������
		if (null == convertView) {
			convertView = layoutInflater.inflate(R.layout.news_card, null);
		}

		// CustomData�̃f�[�^��View�̊eWidget�ɃZ�b�g����
		ImageView imageView;
		imageView = (ImageView) convertView.findViewById(R.id.newsISmage);
		imageView.setImageBitmap(item.getImg());

		TextView textView;
		textView = (TextView) convertView.findViewById(R.id.newsTitle);
		textView.setText(item.getTitle());

		return convertView;
	}
}
