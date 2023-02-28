package com.xiongtao.httprequest_hilt.network.callback;

/**
 * 顶层的回调接口   string---->json,xml,protobuff
 */
public interface ICallback {
    void onSuccess(String result); // InputStream,String,Object,T
    void onFailure(String e);
}
