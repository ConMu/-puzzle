package demo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mucongcong
 * @date 2022/08/30 10:29
 * @since
 **/
public class DemoMain2 {
    public static void main(String[] args) {
        SysConfig.init();
        Integer eventType = 12;
        Integer appId = 12345;

        String mobile = "18662863296";
        String content = "T";
        long replyTime = 10000000L;

        JSONObject body = new JSONObject();
        body.put("businessid", "9999");
        body.put("mobile", mobile);
        body.put("content", content);
        body.put("extendcode", "nimextendcode");
        body.put("uplinktime", replyTime);

        boolean flag = SysConfig.getUplinkPersonalFlag(appId);
        if (flag) {
            Map<String, String> params = new HashMap<>();
            addParams(params, appId);
            addSendParams(params,appId,mobile);
            params.put("mobile", mobile);
            params.put("content", content);
            params.put("replytime", String.valueOf(replyTime));
            String tempalte = SysConfig.getPersonalTemplate(appId);
            if (tempalte.isEmpty()) {
                return;
            }
            String templateString = VideoTemplateUtils.formatTemplate(tempalte, params);
            body = JSONObject.parseObject(templateString);
        }

        doCallback(body);
    }

    private static void doCallback(JSONObject routeSmsReply) {
        for (Map.Entry<String, Object> entry : routeSmsReply.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private static void addSendParams(Map routeSmsReply, Integer appId, String mobile) {
        String timeDay = SysConfig.getUplinkPersonalTimeRange(appId);
        if (timeDay.isEmpty()) {
            return;
        }
        String detail = SysConfig.getUplinkPersonalSendAddDetail(appId);
        if (detail.isEmpty()) {
            return;
        }
        SmsSendRecord smsSendRecord = new SmsSendRecord();
        smsSendRecord.setNimid("abcdefg");
        String[] split = detail.split(";");
        try {
            for (String s : split) {
                Field f = smsSendRecord.getClass().getDeclaredField(s);
                f.setAccessible(true);
                Object reflectValue = f.get(smsSendRecord);
                routeSmsReply.put(s, String.valueOf(reflectValue));
            }
        } catch(Exception e) {
            System.out.println(e);
            return;
        }
    }

    private static void addParams(Map requestObject, Integer appId) {
        String detail = SysConfig.getUplinkPersonalAddDetail(appId);
        if (detail.isEmpty()) {
            return;
        }
        String[] split = detail.split(";");
        for (String s : split) {
            String[] addKey = s.split(":");
            requestObject.put(addKey[0], addKey[1]);
        }
    }
}
