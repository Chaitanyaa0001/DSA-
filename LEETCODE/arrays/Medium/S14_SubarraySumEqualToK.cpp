package LEETCODE.arrays.Medium;

import java.util.HashMap;

public class S14_SubarraySumEqualToK {
    private static int bruetforce(int a[], int k){
        int count = 0; 
        for(int i = 0; i < a.length; i++){
            int sum = 0;
            for(int j = i;  j < a.length; j++){
                sum += a[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    private static int optimal(int a[], int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = a.length;
        int count  = 0;
        int sum = 0;
        map.put(0,1);
        for(int i = 0; i < n; i++){
            sum += a[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int a[] = {2,8,3,2,3,4,2,4,6,7,9};
        int k = 14;
        bruetforce(a, k);
        optimal(a, k);
    }
}
