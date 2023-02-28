package com.xiongtao.httprequest_proxy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xiongtao.httprequest_proxy.bean.ResponseData;
import com.xiongtao.httprequest_proxy.network.callback.HttpCallback;
import com.xiongtao.httprequest_proxy.network.help.HttpHelper;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 公网支持
                String url = "https://v.juhe.cn/historyWeather/citys";
                HashMap<String, Object> params = new HashMap<>();
                // https://v.juhe.cn/historyWeather/citys?&province_id=2&key=bb52107206585ab074f5e59a8c73875b
                params.put("province_id", "2");
                params.put("key", "bb52107206585ab074f5e59a8c73875b");

                HttpHelper.obtain().post(url, params, new HttpCallback<ResponseData>() {
                    @Override
                    public void onSuccess(ResponseData objResult) {
                        Toast.makeText(MainActivity.this, objResult.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    // TODO APP端 买房的人 （刚需）
    public void click(View view) {

    }
}