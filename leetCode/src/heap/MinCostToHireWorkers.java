package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToHireWorkers {

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        Worker[] workers = new Worker[len];
        for (int i = 0; i < len; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);
        /*double ans = 1e9;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue();
        for (Worker worker: workers) {
            pool.offer(-worker.quality);
            sumq += worker.quality;
            if (pool.size() > k)
                sumq += pool.poll();
            if (pool.size() == k)
                ans = Math.min(ans, sumq * worker.ratio());
        }*/
        double ans = Double.MAX_VALUE;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue<>();
        for (Worker worker : workers) {
            pool.offer(-worker.quality);
            sumq += worker.quality;
            if (pool.size() > k) {
                sumq += pool.poll();
            }
            if (pool.size() == k) {
                ans = Math.min(ans, worker.ratio() * sumq);
            }

        }

        return ans;



    }



    private static class Worker implements Comparable<Worker>{
        public int quality;
        public int wage;

        public Worker(int q, int w) {
            this.quality = q;
            this.wage = w;
        }
        public double ratio () {
            return (double) wage / quality;
        }

        public int compareTo(Worker other) {
            return Double.compare(ratio(), other.ratio());
        }
    }
}
