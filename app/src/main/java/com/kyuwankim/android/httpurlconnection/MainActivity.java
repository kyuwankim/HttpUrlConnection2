package com.kyuwankim.android.httpurlconnection;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);

        String url = "http://google.com";
        newTask(url);
    }

    // thread 를 생성
    public void newTask(String url){
        new AsyncTask<String, Void, String>(){
            // 백그라운드 처리 함수
            @Override
            protected String doInBackground(String... params) {
                String result = "";
                try {
                    // getData 함수로 데이터를 가져온다.
                    result = getData(params[0]);
                    Log.i("Network", result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return result;
            }


            @Override
            protected void onPostExecute(String result) {

                textView.setText(result);
            }
        }.execute(url);


    }

    // 인자로 받은 url 로 네트웍을 통해 데이터를 가져오는 함수
    public String getData(String url) throws Exception {  // <- 요청한 곳에서 Exception 처리를 해준다.
        String result = "";

        // 네트웍 처리
        // 1. 요청처리 Request
        // 1.1 URL 객체 만들기
        URL serverUrl = new URL(url);
        // 1.2 연결객체 생성
        HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection(); // url 객체에서 연결을 꺼낸다.
        // 1.3 http method 결정
        con.setRequestMethod("GET");

        // 2. 응답처리 Response
        // 2.1 응답코드 분석
        int responseCode = con.getResponseCode();
        // 2.2 정상적인 응답처리
        if(responseCode == HttpURLConnection.HTTP_OK){ // 정상적인 코드 처리

            BufferedReader br = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
            String temp = null;

            while( (temp = br.readLine()) != null){
                result += temp;
            }
            // 2.3 오류에 대한 응답처리
        } else {
            Log.e("Network","error_code="+responseCode);
        }

        return result;
    }
}