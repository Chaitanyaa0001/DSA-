// Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.
// Example 1
// Input: nums = [10, 5, 2, 7, 1, 9],  k=15
// Output: 4
// Explanation:
// The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.
// Example 2
// Input: nums = [-3, 2, 1], k=6
// Output: 0
// Explanation:
// There is no sub-array in the array that sums to 6. Therefore, the output is 0.


import java.util.HashMap;
import java.util.Scanner;

import LEETCODE.arrays.ArrayInput;

public class S13_Positive_LongestSubarraywithsumK {
    private static int  bruteforce(int nums[], int k){
        int n  =nums.length;
        int maxlen = -1;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum = sum + nums[j];
                if(sum == k){
                    int len =  j - i + 1;
                    maxlen = Math.max(maxlen,len); 
                }
            }
        }
        return maxlen;
    }
    // it is better when there are only positbve numbers 
    private static int betterapprochusinghashMap(int [] nums, int k){
       int n = nums.length;
       HashMap <Integer,Integer> map = new HashMap<>();
       int sum = 0;
       int maxlen = 0;
       for(int i = 0; i < n; i++){
           sum += nums[i];
           if( sum == k ){
              maxlen = i + 1;

           }
           if(map.containsKey(sum -k)){
               int j = map.get(sum-k); 
               int length = i - j +1;
               maxlen = Math.max(maxlen, length);
           }
        //    agar mera map mei ek sum already hai to agar vo duabara ata hai t vo uski value update kr deta hai 
        //    to humko sirf tabhi add krna hai jab already sum nhi ho 
           if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
       }
    //    time : O(n)  hashmap is constant 
       return maxlen;
    }

    private static int optimalApprochSlidingWindow(int[] nums, int k){
        int n = nums.length;
        int maxlen = 0;

        int i = 0;
        int j = 0; 
        int sum = 0;
        while (j < n) {
            sum += nums[i];
            while(sum > k){
               sum = sum - nums[i];
               i++;
            }  
            if(sum == k){
                int len = j - i + 1;
                maxlen = Math.max(maxlen, len);
            } 
            
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = ArrayInput.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int result = bruteforce(nums, k);
        betterapprochusinghashMap(nums, k);
        optimalApprochSlidingWindow(nums, k);
        
        System.out.println(result);
        sc.close();
    }
}