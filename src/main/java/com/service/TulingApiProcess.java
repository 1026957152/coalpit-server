package com.service;/*
package com.service;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import net.sf.json.JSONObject;
*/
/*import org.json.JSONException;
import org.json.JSONObject;*//*


*/
/**
 * 调用图灵机器人api接口，获取智能回复内容 
 * @author pamchen-1 
 * 
 *//*

@Component
public class TulingApiProcess {  
    */
/**
     * 调用图灵机器人api接口，获取智能回复内容，解析获取自己所需结果 
     * @param content 
     * @return 
     *//*



    @Value("${hubotServiceUrl}")
    private String apiUrl;

    public static JSONObject getTulingResult(String apiUrl, String content){
        */
/** 此处为图灵api接口，参数key需要自己去注册申请，先以11111111代替 *//*


       // String apiUrl = "http://www.tuling123.com/openapi/api?key=11111111&info=";
        String param = "";

        try {
            URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost(apiUrl)
                    .setPath("/search")
                    .setParameter("q", "httpclient")
                    .setParameter("btnG", "Google Search")
                    .setParameter("aq", "f")
                    .setParameter("oq", "")
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        try {  
            param = apiUrl+URLEncoder.encode(content,"utf-8");
        } catch (UnsupportedEncodingException e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        } //将参数转为url编码  
          
        */
/** 发送httpget请求 *//*



        HttpGet request = new HttpGet(param);  
        String result = "";  
        try {  
            HttpResponse response = HttpClients.createDefault().execute(request);
            if(response.getStatusLine().getStatusCode()==200){  
                result = EntityUtils.toString(response.getEntity());
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        */
/** 请求失败处理 *//*

        if(null==result){  
           // return "对不起，你说的话真是太高深了……";
        }  
          
      try {

JSONObject json = JSONObject.parseObject(result);
           // JSONObject json = new JSONObject(result);
            //以code=100000为例，参考图灵机器人api文档  
            if(true==json.getBoolean("status")){
                result = json.getString("text");  
            }     return json;
        } catch (JSONException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }

        return null;
    }


    public static String getTulingResultPost(String content,Map<String,String> map){
        */
/** 此处为图灵api接口，参数key需要自己去注册申请，先以11111111代替 *//*


        String apiUrl = "http://localhost:9086/hubot/on_message_send";

        HttpPost request = new HttpPost(apiUrl);

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(map!=null){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        System.out.println("开始 处理 对不起，你说的话真是太高深了……");

        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(10000).setConnectTimeout(10000)
                .setSocketTimeout(10000).build();
        //设置参数到请求对象中
        try {
            request.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.setConfig(config);


        */
/** 发送httpget请求 *//*




        String result = "";
        try {
            HttpResponse response = HttpClients.createDefault().execute(request);
            if(response.getStatusLine().getStatusCode()==200){
                result = EntityUtils.toString(response.getEntity());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
/** 请求失败处理 *//*

        if(null==result){
            return "对不起，你说的话真是太高深了……";
        }
        System.out.println("结束 处理 ");
*/
/*        try {

JSONObject json = JSONObject.fromObject(str);
            JSONObject json = new JSONObject(result);
            //以code=100000为例，参考图灵机器人api文档
            if(100000==json.getInt("code")){
                result = json.getString("text");
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  *//*

        return result;
    }

    private static final String APPLICATION_JSON = "application/json";

    public static String getTulingResultPostStateEvent(String apiUrl,Map<String,String> map,String jsonString){
        */
/** 此处为图灵api接口，参数key需要自己去注册申请，先以11111111代替 *//*




        HttpPost request = new HttpPost(apiUrl);

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(map!=null){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        System.out.println("开始 处理 对不起，你说的话真是太高深了……");

        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(10000).setConnectTimeout(10000)
                .setSocketTimeout(10000).build();
        //设置参数到请求对象中
        try {
           // request.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            StringEntity se = new StringEntity(jsonString);
            request.setEntity(se);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
        request.setConfig(config);


        */
/** 发送httpget请求 *//*




        String result = "";
        try {
            HttpResponse response = HttpClients.createDefault().execute(request);
            if(response.getStatusLine().getStatusCode()==200){
                result = EntityUtils.toString(response.getEntity());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
/** 请求失败处理 *//*

        if(null==result){
            return "对不起，你说的话真是太高深了……";
        }
        System.out.println("结束 处理 ");
*/
/*        try {

JSONObject json = JSONObject.fromObject(str);
            JSONObject json = new JSONObject(result);
            //以code=100000为例，参考图灵机器人api文档
            if(100000==json.getInt("code")){
                result = json.getString("text");
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  *//*

        return result;
    }
}  */
