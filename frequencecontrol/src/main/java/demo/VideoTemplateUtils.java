package demo;

import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.CompositeStringExpression;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author mucongcong
 * @date 2022/08/30 17:47
 * @since
 **/
public class VideoTemplateUtils {

    private static final ExpressionParser EXPRESSION_PARSER = new SpelExpressionParser();

    private static final Pattern SMS_VIDEO_PARAM_PATTERN = Pattern.compile("^[A-Za-z0-9]{1,10}$");

    public static void main(String[] args) {
        String aaa = "{\n" +
                "    \"sc_id\": \"#{scId}\",\n" +
                "    \"msg_reply_list\": [\n" +
                "        {\n" +
                "            \"sc_task_id\": \"#{sendId}\",\n" +
                "            \"phone_number\": \"#{mobile}\",\n" +
                "            \"content\": \"#{content}\",\n" +
                "            \"reply_time\": \"#{replytime}\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        Map<String, String> params = new HashMap<>();
        params.put("scId", "123");
        params.put("sendId", "546");
        params.put("mobile", "13100000000");
        params.put("content", "T");
        params.put("replytime", "2022-08-30 12:12:12");
        System.out.println(formatTemplate(aaa, params));
    }

    /**
     * 获取模板参数列表
     *
     * @param template 模板字符串
     * @return 模板参数列表
     */
    public static List<String> getTemplateParams(String template) {
        List<String> params = new ArrayList<>();
        Expression expression = EXPRESSION_PARSER.parseExpression(template, ParserContext.TEMPLATE_EXPRESSION);
        if (expression instanceof CompositeStringExpression) {
            //模板有参数
            CompositeStringExpression compositeStringExpression = (CompositeStringExpression) expression;
            Expression[] expressions = compositeStringExpression.getExpressions();
            for (Expression exp : expressions) {
                if (exp instanceof SpelExpression) {
                    params.add(exp.getExpressionString());
                }
            }
        } else if (expression instanceof SpelExpression) {
            params.add(expression.getExpressionString());
        }
        return params;
    }

    /**
     * 模板参数渲染
     *
     * @param template 模板字符串
     * @param params   模板参数列表
     * @return 渲染后的模板内容
     */
    public static String formatTemplate(String template, Map<String, String> params) {
        StandardEvaluationContext context = new StandardEvaluationContext(params);
        context.addPropertyAccessor(new MapAccessor());
        Expression expression = EXPRESSION_PARSER.parseExpression(template, ParserContext.TEMPLATE_EXPRESSION);
        return expression.getValue(context, String.class);
    }

    /**
     * 校验变量
     *
     * @param param 变量
     * @return true 符合要求，false 不符合要求
     */
    public static boolean checkVideoParam(String param) {
        // 变量名称规则 变量名格式为10字以内的英文、数字
        return SMS_VIDEO_PARAM_PATTERN.matcher(param).matches();
    }
}
