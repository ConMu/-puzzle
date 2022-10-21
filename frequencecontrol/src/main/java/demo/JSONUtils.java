package demo;

/**
 * @author mucongcong
 * @date 2022/09/02 14:00
 * @since
 **/
public class JSONUtils {
    private static final String[] REPLACEMENT_CHARS;

    static {
        REPLACEMENT_CHARS = new String[128];
        for (int i = 0; i <= 0x1f; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", (int) i);
        }
        REPLACEMENT_CHARS['"'] = "\\\"";
        REPLACEMENT_CHARS['\\'] = "\\\\";
        REPLACEMENT_CHARS['\t'] = "\\t";
        REPLACEMENT_CHARS['\b'] = "\\b";
        REPLACEMENT_CHARS['\n'] = "\\n";
        REPLACEMENT_CHARS['\r'] = "\\r";
        REPLACEMENT_CHARS['\f'] = "\\f";
    }

    /**
     * JSON 特殊字符处理
     *
     * @param value 字符内容
     * @return 处理后字符串
     */
    public static String formatJsonValue(String value) {
        StringBuilder resp = new StringBuilder();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char c = value.charAt(i);
            String replacement = null;
            if (c < 128) {
                replacement = REPLACEMENT_CHARS[c];
            } else if (c == '\u2028') {
                replacement = "\\u2028";
            } else if (c == '\u2029') {
                replacement = "\\u2029";
            }
            if (replacement != null) {
                resp.append(replacement);
            } else {
                resp.append(c);
            }
        }
        return resp.toString();
    }
}
