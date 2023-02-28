package com.xiongtao.httprequest_hilt.network;

import com.xiongtao.httprequest_hilt.network.callback.ICallback;
import com.xiongtao.httprequest_hilt.network.http.IHttpRequest;

import java.util.Map;

import javax.inject.Inject;

// TODO 真实的网络操作（业主，有房的人）
public class OtherRequest implements IHttpRequest {

    @Inject
    public OtherRequest() {
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {

    }

    @Override
    public void get(String url, ICallback callback) {

    }
}
