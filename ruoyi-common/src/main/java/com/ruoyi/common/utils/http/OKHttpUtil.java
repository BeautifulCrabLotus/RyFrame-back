package com.ruoyi.common.utils.http;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/12/25.
 */
public class OKHttpUtil {

    private static final OkHttpClient client = new OkHttpClient();
    

    private static Map<String, Object> result;

    public static Headers setHeaders(Map<String,Object> headersParams) {
        Headers headers = null;
        Headers.Builder builder = new Headers.Builder();
        for (String key:headersParams.keySet()) {
            builder.add(key, headersParams.get(key).toString());
        }
        headers = builder.build();
        return headers;
    }

    public static RequestBody setBodys(JSONObject bodyParams) {
        MediaType type = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(type,bodyParams.toString());
        return requestBody;
    }

    public static RequestBody setBodys(Map<String,Object> bodyParams){
        RequestBody requestBody = null;
        FormBody.Builder builder = new FormBody.Builder();
        for (String key: bodyParams.keySet()) {
            builder.add(key, bodyParams.get(key).toString());
        }
        return builder.build();
    }

    public static Map<String,Object> dopostByForm(String url, JSONObject jsonObject) throws IOException {
        Map<String, Object> result = new HashMap<>();
        RequestBody requestBody = new FormBody.Builder().add("appKey",jsonObject.getString("appKey"))
                .add("appSecret",jsonObject.getString("appSecret")).build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = client.newCall(request).execute();
        result.put("status", response.code());
        result.put("result", response.body().string());
        return result;
    }

    public static Map<String,Object> dopostPic(String url, JSONObject jsonObject) throws IOException {
        Map<String, Object> result = new HashMap<>();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
        RequestBody requestBody = new FormBody.Builder().add("accessToken",jsonObject.getString("accessToken"))
                .add("deviceSerial",jsonObject.getString("deviceSerial")).add("channelNo",jsonObject.getString("channelNo")).build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = client.newCall(request).execute();
        result.put("status", response.code());
        result.put("result", response.body().string());
        return result;
    }

    public static Map<String,Object> dopostByFormToken(String url, JSONObject jsonObject) throws IOException {
        Map<String, Object> result = new HashMap<>();
        RequestBody requestBody = new FormBody.Builder().add("deviceSerial",jsonObject.getString("deviceSerial"))
                .add("accessToken",jsonObject.getString("accessToken")).build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = client.newCall(request).execute();
        result.put("status", response.code());
        result.put("result", response.body().string());
        return result;
    }

    /**
     * 无参数无头部参数的GET请求
     *
     * @paramurl请求接口地址
     * @returnstatus:请求状态码，result：接口返回数据（转为string处理）
     * @throwsIOException
     */
    public static Map<String, Object> doget(String url) throws IOException {
        result = new HashMap<>();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        result.put("status", response.code());
        result.put("result", response.body().string());
        return result;
    }

    /**
     * 携带头部信息的GET请求
     *
     * @return
     * @paramurl
     * @paramheadersMap
     * @throwsIOException
     */
    public static Map<String, Object> doget(String url, Map<String, Object> headersMap)throws IOException {
        result = new HashMap <>();
        Request request = new Request.Builder().headers(setHeaders(headersMap)).build();
        Response response = client.newCall(request).execute();
        result.put("status", response.code());
        result.put("result", response.body().string());
        return result;
    }

    public static Map<String, Object> dopost(String url, Map<String, Object> headers, JSONObject params)throws IOException {
        result = new HashMap <>();
        Request request = new Request.Builder().url(url).headers(setHeaders(headers)).post(setBodys(params)).build();
        Response response = client.newCall(request).execute();
        result.put("status", response.code());
        result.put("result", response.body().string());
        return result;
    }

    public static Map<String, Object> dopost(String url, JSONObject params)throws IOException {
        result = new HashMap <>();
        Request request = new Request.Builder().url(url).post(setBodys(params)).build();
        Response response = client.newCall(request).execute();
        result.put("status", response.code());
        result.put("result", response.body().string());
        return result;
    }

    public static Map<String,Object> dopost(String url, JSONArray jsonArray) throws IOException {
        result = new HashMap <>();
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType,jsonArray.toJSONString());
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = client.newCall(request).execute();
        result.put("status", response.code());
        result.put("result", response.body().string());
        return result;
    }

    public static Map<String,Object> dopost(String url, Map<String,Object> headersParam,JSONArray jsonArray) throws IOException {
        result = new HashMap <>();
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType,jsonArray.toJSONString());
        Request request = new Request.Builder().url(url).headers(setHeaders(headersParam)).post(requestBody).build();
        Response response = client.newCall(request).execute();
        result.put("status", response.code());
        result.put("result", response.body().string());
        return result;
    }


    public static Map<String,Object> dopost(int connectTimeout,int readTimeout,String url, Map<String,Object> headersParam,String jsonString) throws IOException {
    	OkHttpClient client = new OkHttpClient.Builder().connectTimeout(connectTimeout, TimeUnit.SECONDS)
				.readTimeout(readTimeout, TimeUnit.SECONDS).build();

    	result = new HashMap <>();
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType,jsonString);
        Request request = new Request.Builder().url(url).headers(setHeaders(headersParam)).post(requestBody).build();
        Response response = client.newCall(request).execute();
        result.put("status", response.code());
        result.put("result", response.body().string());
        return result;
    }

    public static Map<String, Object> dopost(String uriStr, Map<String,String> headers, List<NameValuePair> pairs) throws IOException, URISyntaxException {

        //设置请求方式与参数
        URI uri = new URI(uriStr);
        HttpPost httpPost = new HttpPost(uri);
        httpPost.getParams().setParameter("http.socket.timeout", new Integer(500000));
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
        httpPost.setHeader("IConnection", "close");
        Set<String> keySet = headers.keySet();
        for (String key : keySet) {
            httpPost.setHeader(key, headers.get(key));
        }

        httpPost.setEntity(new UrlEncodedFormEntity(pairs));

        //执行请求
        HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter("Content-Encoding", "UTF-8");
        HttpResponse response = httpclient.execute(httpPost);

        //获取返回
        HttpEntity entity = response.getEntity();
        BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8));
        StringBuffer buffer = new StringBuffer();
        String line = null;
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        in.close();
        result = new HashMap<>();
        result.put("result", buffer.toString());
        return result;
    }


    public static void main(String[] args) throws IOException, ParseException {
//        JSONObject json = new JSONObject();
//        json.put("Account","njxqs");
//        json.put("Password","123456");
//        Map<String, Object> map = dopost("http://wisdomapi.edaoke.cn/api/appapi/Login", json);
//        System.out.println(map);
//        Object staffid = ((Map<String ,Object>)map.get("result")).get("Data");
//        Map<String, Object> result = doget("http://njtestapi.edaoke.cn/api/appapi/getdatacenter?staffid=" +staffid );
//        System.out.println(result);

        /*String timestamp = GetTimeStamp();
        String random = GetRandom();
        String signature = GetSignature(timestamp,random,"123456","595008a8-4964-4245-9819-c15029b6c0d5");
        OkHttpClient mOkHttpClient = new OkHttpClient();
        MediaType JSON=MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, "");
        Request request = new Request.Builder()
                .url("http://njtestapi.edaoke.cn/api/AppApi/Datacenter")
                .addHeader("staffid", "d2be6594-904d-420e-83fc-def3ce137cde")//当前请求用户StaffId,是个随机数
                .addHeader("timestamp", timestamp)//发起请求时的时间戳（单位：毫秒）
                .addHeader("nonce", random)//随机数
                .addHeader("signature", signature)//计算签名
                .post(requestBody)
                .build();
       mOkHttpClient.newCall(request)
                .enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("ex>>"+e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("ok:>>"+response.toString());
            }
        });*/


    }
    
}
