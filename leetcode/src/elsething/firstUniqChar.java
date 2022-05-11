package elsething;

import java.util.HashMap;
import java.util.Map;

public class firstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++) {
            // char ch = s.charAt(i);
            // map.put(ch, map.getOrDefault(ch,0)+ 1);
            //getOrDefault​(Object key, V defaultValue) 返回指定键映射到的值，如果此映射不包含键的映射，则返回 defaultValue 。
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+ 1);
        }
        for(int i = 0;i<s.length();i++) {
            if(map.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
