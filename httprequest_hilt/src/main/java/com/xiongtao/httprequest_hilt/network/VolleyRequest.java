package com.xiongtao.httprequest_hilt.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.xiongtao.httprequest_hilt.network.callback.ICallback;
import com.xiongtao.httprequest_hilt.network.http.IHttpRequest;

import java.util.Map;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;

// TODO 真实的网络操作（业主，有房的人）
public class VolleyRequest implements IHttpRequest {

    private static RequestQueue mQueue = null;

    @Inject // 注意：如果构造函数需要传递Context，可以使用@ApplicationContext 把Context带入进来给构造函数
    public VolleyRequest(@ApplicationContext Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(stringRequest);
    }

    @Override
    public void get(String url, ICallback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(stringRequest);
    }
}