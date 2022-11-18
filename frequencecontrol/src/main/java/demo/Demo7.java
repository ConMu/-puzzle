package demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mucongcong
 * @date 2022/11/15 15:15
 * @since
 **/
public class Demo7 {
    public static void main(String[] args) {
        String s = "[\"online/nginx/clusters/we-yunxin/upstreams/voip-sms-api-docker-voip_sms_online/10.156.162.239:9191\",\"online/nginx/clusters/we-yunxin/upstreams/voip-sms-api-docker-voip_sms_online/10.156.178.50:9191\",\"online/nginx/clusters/we-yunxin/upstreams/voip-sms-api-docker-voip_sms_online/10.156.182.27:9191\",\"online/nginx/clusters/we-yunxin/upstreams/voip-sms-api-docker-voip_sms_online/10.156.228.110:9191\",\"online/nginx/clusters/we-yunxin/upstreams/voip-sms-api-docker-voip_sms_online/10.156.228.200:9191\",\"online/nginx/clusters/we-yunxin/upstreams/voip-sms-api-docker-voip_sms_online/10.156.237.60:9191\"]";
        List<String> list = JSONArray.parseArray(s,String.class); // 首先把字符串转成 JSONArray  对象
        for (String li : list) {
//            System.out.println(li);
            String[] split = li.split("/");
            System.out.println(split[split.length-1]);
        }

    }
}
