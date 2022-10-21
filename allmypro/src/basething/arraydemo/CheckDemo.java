package basething.arraydemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mucongcong
 * @date 2022/10/10 16:41
 * @since
 **/
public class CheckDemo {
    private static final String SPLIT = ",";

    public static <T> void checkCodeIsLegal(T param, String paramName, List<T> validParams){
        if (param == null) {
            System.out.println(paramName + " is empty!");
        }
        if (!validParams.contains(param)) {
            System.out.println(paramName + " is illegal!");
        }
    }
    private static List<String> getChannelids(String channelid, String split) {
        return Arrays.asList(channelid.split(split));
    }
    public static void main(String[] args) {
//        Integer s = 2;
//        List<Integer> list = Arrays.asList(1, 3);
//        checkCodeIsLegal(null,"a",list);
//        System.out.println("----测试完成----");

//        String channelids = "a,2,3";
//        List<String> channelidList = getChannelids(channelids,SPLIT);
//        List<Integer> ss = channelidList.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
//        System.out.println(1);

        List<String> list = Arrays.asList("GB:0002","GB:0003","GB:0007","GB:0008","GB:0009"
                ,"GB:0014","GB:0016","GB:0019","GB:0021","GB:0022","UNDELIV","DELIVRD","elseReport1"
                ,"elseReport2","elseReport3","elseReport4","elseReport5");
        int index = (int) (Math.random()* list.size());
        System.out.println(list.get(index));
    }
}
