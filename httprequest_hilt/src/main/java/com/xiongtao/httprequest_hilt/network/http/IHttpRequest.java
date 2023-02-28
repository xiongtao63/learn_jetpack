package com.xiongtao.httprequest_hilt.network.http;

import com.xiongtao.httprequest_hilt.network.callback.ICallback;

import java.util.Map;

/**
 * 房产公司
 */
public interface IHttpRequest {
    // 有卖房的能力
    // 网络访问的能力
    void post(String url, Map<String, Object> params, ICallback callback);

    void get(String url, ICallback callback);
}
