package LEETCODE.arrays;

public class profitloss {
    public static int maxprofit(int prices[]){
        int buyingprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i < prices.length; i++){
            if(buyingprice < prices[i]){
                int profit = prices[i] - buyingprice;
                maxprofit = Math.max(profit, maxprofit);
            }else{
                buyingprice = prices[i];
            };
        };
        return  maxprofit;
    }
    public static void main(String[] args) {
        int prices[] =  {7, 1, 5, 3, 6, 4} ;
        int resut =   maxprofit(prices);
        System.out.println(resut);
       
    }
}
