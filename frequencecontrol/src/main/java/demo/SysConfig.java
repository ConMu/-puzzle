package demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author mucongcong
 * @date 2022/08/29 17:50
 * @since
 **/
public class SysConfig {
    private static Properties properties = new Properties();

    public static boolean getUplinkPersonalFlag(long appid) {
        String key = concatAppConfigKey(appid, "UplinkPersonalFlag");
        try {
            String property = properties.getProperty(key);
            if (property.equals("true")) {
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            return false;
        }
    }


    public static String getSmsCallbackPersonalizedRebuildDetail(long appid) {
        String key = concatAppConfigKey(appid, "SmsCallbackPersonalizedRebuildDetail");
        try {
            String property = properties.getProperty(key);
            return property;
        } catch(Exception e) {
            return "";
        }
    }

    private static String concatAppConfigKey(long appId, String key) {
        return appId + "." + key;
    }

    public static void init() {
        try {
            ClassLoader classLoader = SysConfig.class.getClassLoader();
            InputStream is = classLoader.getResourceAsStream("serverconfig.properties");
            properties.load(is);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static String getUplinkPersonalAddDetail(Integer appid) {
        String key = concatAppConfigKey(appid, "UplinkPersonalAddDetail");
        try {
            String property = properties.getProperty(key);
            return property;
        } catch(Exception e) {
            return "";
        }
    }


    public static String getUplinkPersonalTimeRange(Integer appid) {
        String key = concatAppConfigKey(appid, "UplinkPersonalTimeRange");
        try {
            String property = properties.getProperty(key);
            return property;
        } catch(Exception e) {
            return "1";
        }
    }

    public static String getUplinkPersonalSendAddDetail(Integer appid) {
        String key = concatAppConfigKey(appid, "UplinkPersonalSendAddDetail");
        try {
            String property = properties.getProperty(key);
            return property;
        } catch(Exception e) {
            return "";
        }
    }

    public static String getPersonalTemplate(Integer appid) {
        String key = concatAppConfigKey(appid, "PersonalTemplate");
        try {
            String property = properties.getProperty(key);
            return property;
        } catch(Exception e) {
            return "";
        }
    }
}
