package demo;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.util.*;

/**
 * @author mucongcong
 * @date 2022/11/17 14:04
 * @since
 **/
public class RandomSelector {

    private final long HASH_Max = 4294967295L;
//    private final long HASH_Max = 105L;

    private TreeSet<Long> treeHash = new TreeSet<>();

    private TreeMap<Long,Long> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        RandomSelector randomSelector = new RandomSelector();
        randomSelector.initHash(100);
            for (long i = 0; i < 10000L; i++) {
                final int seed = 42;
                String uuid = UUID.randomUUID().toString();
                byte[] bytes = uuid.getBytes();
                HashFunction guava2 = Hashing.murmur3_32(seed);
                HashCode guavaCode2 = guava2.hashBytes(bytes);
                long randomNumber = Long.parseLong(guavaCode2.toString(), 16);
//        long randomNumber = 4294967201L;
//        System.out.println("randomNumber:" + randomNumber);
                Long ceil = randomSelector.treeHash.ceiling(randomNumber);
                randomSelector.treeMap.put(ceil, randomSelector.treeMap.get(ceil) + 1);
            }
            for (Map.Entry<Long,Long> entry: randomSelector.treeMap.entrySet()) {
                Long key = entry.getKey();
                Long value = entry.getValue();

//                System.out.println("key:" + key);
//                System.out.println("value:" + value);
            }
            Long min = Collections.min(randomSelector.treeMap.values());
            Long max = Collections.max(randomSelector.treeMap.values());
//        System.out.println("min:===>" + min);
//        System.out.println("max:===>" + max);
            System.out.println(max - min);



    }

    private void initHash(int splice) {
        long eachPart = HASH_Max / splice;
        long c = HASH_Max % splice;
        long start = 0;
        for (int i = 0; i < splice ; i++) {
            if (c != 0 && i != 0) {
                start += eachPart + 1;
                this.treeHash.add(start);
                this.treeMap.put(start, 0L);
                c--;
            } else {
                start += eachPart;
                this.treeHash.add(start);
                this.treeMap.put(start, 0L);
            }
        }
    }

//    public static void main(String[] args) {
//        RandomSelector randomSelector = new RandomSelector();
//        randomSelector.initHash(10);
//        System.out.println();
//    }
}
