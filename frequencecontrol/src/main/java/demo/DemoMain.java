package demo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mucongcong
 * @date 2022/08/29 19:47
 * @since
 **/
public class DemoMain {
    public static void main(String[] args) {
        SysConfig.init();
        Integer eventType = 12;
        Integer appId = 12345;

        String mobile = "18662863296";
        String content = "T";
        String replyTime = "2022/08/20";

        JSONObject routeSmsReply = new JSONObject();
        routeSmsReply.put("mobile", mobile);
        routeSmsReply.put("content", content);
        routeSmsReply.put("replytime", replyTime);

        JSONObject requestObject = new JSONObject();
        requestObject.put("objects", Lists.newArrayList(routeSmsReply));
        requestObject.put("eventType", 12);

        boolean flag = SysConfig.getUplinkPersonalFlag(appId);
        if (flag) {
            Map<String, String> params = new HashMap<>();
            String tempalte = SysConfig.getPersonalTemplate(appId);
            boolean sendStatus = addSendParams(params, appId, mobile);
            if (tempalte.isEmpty() || !sendStatus) {
                return;
            }
            addParams(params, appId);
            params.put("mobile", mobile);
            params.put("content", content);
            params.put("replytime", replyTime);
            String templateString = VideoTemplateUtils.formatTemplate(tempalte, params);

            requestObject = JSONObject.parseObject(templateString);
        }

        doCallback(requestObject);

//        if (flag) {
//            // 字段转变
//            routeSmsReply = doRebuild(routeSmsReply, appId);
//            // 下行数据查询添加 => 通用时间跨度
//            addList(routeSmsReply, appId, "18662863296");
//        }
//
//        JSONObject requestObject = new JSONObject();
//        requestObject.put("objects", Lists.newArrayList(routeSmsReply));
//        if (flag) {
//            requestObject = doRebuild(requestObject, appId);
//            // 多余字段添加 => appid配置写死的
//            addObjects(requestObject,appId);
//        }
//
//        doCallback(requestObject);

    }

    private static boolean addSendParams(Map params, Integer appId, String mobile) {
        String timeDay = SysConfig.getUplinkPersonalTimeRange(appId);
        if (timeDay.isEmpty()) {
            return true;
        }
        String detail = SysConfig.getUplinkPersonalSendAddDetail(appId);
        if (detail.isEmpty()) {
            return true;
        }
        SmsSendRecord smsSendRecord = new SmsSendRecord();
        smsSendRecord.setNimid("abcdefg");

        if (smsSendRecord == null) {
            return false;
        }
        String[] split = detail.split(";");
        try {
            for (String s : split) {
                Field f = smsSendRecord.getClass().getDeclaredField(s);
                f.setAccessible(true);
                Object reflectValue = f.get(smsSendRecord);
                params.put(s, String.valueOf(reflectValue));
            }
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static void addParams(Map params, Integer appId) {
        String detail = SysConfig.getUplinkPersonalAddDetail(appId);
        if (detail.isEmpty()) {
            return;
        }
        String[] split = detail.split(";");
        for (String s : split) {
            String[] addKey = s.split(":");
            params.put(addKey[0], addKey[1]);
        }
    }

    private static JSONObject doRebuild(JSONObject requestObject, Integer appId) {
        String detail = SysConfig.getSmsCallbackPersonalizedRebuildDetail(appId);
        if (detail.isEmpty()) {
            return requestObject;
        }
        JSONObject json = new JSONObject();
        String[] split = detail.split(";");
        for (String s : split) {
            String[] changeKey = s.split(":");
            if (requestObject.containsKey(changeKey[1])) {
                json.put(changeKey[0], requestObject.get(changeKey[1]));
            }
        }
        return json;
    }
    private static void doCallback(JSONObject routeSmsReply) {
        for (Map.Entry<String, Object> entry : routeSmsReply.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }


    private static void doCallback1(JSONObject routeSmsReply) {
        for (Map.Entry<String, Object> entry : routeSmsReply.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
