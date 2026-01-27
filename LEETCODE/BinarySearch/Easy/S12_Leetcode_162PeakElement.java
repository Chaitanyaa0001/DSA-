package LEETCODE.BinarySearch.Easy;

import LEETCODE.BinarySearch.ArrayInp;

public class S12_Leetcode_162PeakElement {
    public static int  brute(int [] nums){
        int n = nums.length;
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-1]) return n - 1;
        for(int i = 1 ; i <= n-1; i++){
            if(nums[i] > nums[i+1] && nums[i] > nums[i-1]){
                return i;
            }
        }
        return -1;
    }
    public static int optimal_Binary(int [] nums){
        int n = nums.length;
        int start = 1;
        int end = n-2;
       if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-1]) return n - 1;

        while (end >= start) {
            int mid = start + (end - start) / 2;

            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }else if(nums[mid] > nums[mid-1]){
                start = mid + 1;
            }else if(nums[mid] > nums[mid+1]){
                end = mid -1;
            }



            
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = ArrayInp.takeArrayInput();
        System.out.println(brute(nums));
    }
}