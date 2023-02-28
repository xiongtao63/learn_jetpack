package com.xiongtao.httprequest_proxy.network.http;

import com.xiongtao.httprequest_proxy.network.callback.ICallback;

import java.util.Map;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-21 16:55
 */
// 房产公司
public interface IHttpRequest {
    // 有买卖房的能力 平台 标准 规则
    // 网络访问的能力
    void post(String url, Map<String,Object> params, ICallback iCallback);

    void get(String url,ICallback iCallback);
}
