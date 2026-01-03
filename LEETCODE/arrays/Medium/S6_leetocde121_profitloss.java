package LEETCODE.arrays.Medium;

import LEETCODE.arrays.ArrayInput;

public class S6_leetocde121_profitloss {

    public static int profitlossques(int[] nums){
        int maxprofit = 0;;
        int buyprice = Integer.MAX_VALUE;
        int n = nums.length;
        int profit = 0;
        for(int i = 0; i < n; i++){
            if( buyprice > nums[i]){
                buyprice = nums[i];
                profit = nums[i] - buyprice;
                maxprofit = Math.max(maxprofit, profit);
            }else{
                buyprice = nums[i];
            }
        }
        return maxprofit;
    }


    
    public static void main(String[] args) {
        int[] nums = ArrayInput.takeArrayInput();

    }
}