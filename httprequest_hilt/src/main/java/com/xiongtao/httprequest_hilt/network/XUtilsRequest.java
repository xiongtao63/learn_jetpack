package com.xiongtao.httprequest_hilt.network;

import android.app.Application;


import com.xiongtao.httprequest_hilt.app.MyApplication;
import com.xiongtao.httprequest_hilt.network.callback.ICallback;
import com.xiongtao.httprequest_hilt.network.http.IHttpRequest;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

import javax.inject.Inject;

// TODO 真实的网络操作（业主，有房的人）
public class XUtilsRequest implements IHttpRequest {

    @Inject // 注意：如果构造函数需要传递Context，可以使用Application 父类 把Application带入进来给构造函数
    public XUtilsRequest(/*MyApplication*/ Application app) {
        // x.Ext.init(app);
        x.Ext.init( (MyApplication) app );
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        RequestParams requestParams = new RequestParams(url);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void get(String url, ICallback callback) {
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
