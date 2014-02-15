package com.kabutomushi.ulsayapps;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Debug;
import android.util.Log;

public class GetNewsTask extends AsyncTask<String, Integer, String> {

	private String data;
	private UlsayActivity mActivity;
	private ArrayList<NewsCardData> mNewsCards;

	public GetNewsTask(UlsayActivity activity) {
		mActivity = activity;
	}

	@Override
	protected String doInBackground(String... params) {
		HttpClient httpClient = new DefaultHttpClient();
		StringBuilder uri = new StringBuilder(
				"http://www5013uo.sakura.ne.jp:3000/fetchRss");
		HttpGet request = new HttpGet(uri.toString());
		HttpResponse response = null;

		try {
			response = httpClient.execute(request);
		} catch (Exception e) {
			Log.d("ulsay", "�ڑ��G���[:" + e);
			data = "error";
		}

		int statusCode = response.getStatusLine().getStatusCode();

		// �ڑ����Ȃ�������f�[�^��荞��
		if (statusCode == HttpStatus.SC_OK) {
			try {
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				response.getEntity().writeTo(outputStream);
				data = outputStream.toString();
				Log.d("ulsay", data);

				// JSON���p�[�X����
				try {
					JSONArray jsonArray = new JSONArray(data);
					mNewsCards = new ArrayList<NewsCardData>();
//					Bitmap img;
//					img = BitmapFactory.decodeResource(mActivity.getResources(), R.drawable.sample);
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject json = jsonArray.getJSONObject(i);
						Log.d("ulsay", json.getString("title"));
						NewsCardData item = new NewsCardData();
						item.setTitle(json.getString("title"));
//						item.setImg(img);
						mNewsCards.add(item);
					}
 				   
				} catch (Exception e) {
					Log.d("ulsay", "failed json array parse." + e);
					return data;
				}

			} catch (Exception e) {
				Log.d("ulsay", "�f�[�^�擾�G���[");
				data = "error";
			}
		} else {
			Log.d("ulsay", "�G���[�F" + statusCode);
			data = "error";
		}
		return data;
	}
	
	protected void onPostExecute(String result) {
		mActivity.setCards(mNewsCards);
	}
}
