package com.xiongtao.httprequest_hilt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xiongtao.httprequest_hilt.app.MyApplication;
import com.xiongtao.httprequest_hilt.bean.ResponseData;
import com.xiongtao.httprequest_hilt.network.callback.HttpCallback;
import com.xiongtao.httprequest_hilt.network.http.IHttpRequest;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    IHttpRequest iHttpRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iHttpRequest = ((MyApplication) getApplication()).getHttpRequest();
        click();
    }


    // TODO APP端 买房的人 刚需
    public void click() {
        // 公网地址
        String url = "https://v.juhe.cn/historyWeather/citys";
        HashMap<String, Object> params = new HashMap<>();
        // https://v.juhe.cn/historyWeather/citys?&province_id=2&key=bb52107206585ab074f5e59a8c73875b
        params.put("province_id", "2");
        params.put("key", "bb52107206585ab074f5e59a8c73875b");

        iHttpRequest.post(url, params, new HttpCallback<ResponseData>() {
            @Override
            public void onSuccess(ResponseData objResult) {
                Toast.makeText(MainActivity.this, objResult.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}