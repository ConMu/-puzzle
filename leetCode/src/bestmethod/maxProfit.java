package bestmethod;

public class maxProfit {
    public int maxProfit(int[] prices) {
        // int tmp = 0 ;
        // for(int i = 0;i< prices.length-1;i++){
        //     for(int j = i + 1;j<prices.length;j++){
        //         tmp = tmp > prices[j] - prices[i] ? tmp: (prices[j] - prices[i]);
        //     }
        // }
        // return tmp;
        if(prices == null || prices.length < 2) return 0;
        int minnum = prices[0],res = 0;

        for(int i = 1;i<prices.length;i++) {
            minnum = Math.min(prices[i],minnum);
            res = Math.max(prices[i] - minnum,res);
        }
        return res;
    }
}
