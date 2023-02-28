package com.xiongtao.httprequest_proxy.network.callback;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-21 16:57
 */
/**
 * 把结果集 请求的 结果 怎么给用户
 */
public interface ICallback {

    void onSuccess(String result); // InputStream,String,Object,T

    void onFailure(String e);

}
