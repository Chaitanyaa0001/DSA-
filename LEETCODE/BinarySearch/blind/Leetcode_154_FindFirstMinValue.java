package LEETCODE.BinarySearch.blind;

import LEETCODE.BinarySearch.ArrayInp;

public class Leetcode_154_FindFirstMinValue {
    public  static int findMin(int[] nums) {
        int n = nums.length;
        int start = 0; 
        int end = n - 1;
        int ans = Integer.MAX_VALUE;

        while(end >= start){
            int mid = start + (end - start) / 2;
            if(nums[start] == nums[mid] &&  nums[mid] == nums[end]){
                ans = Math.min(ans,nums[start]);
                start++;end--;
            }else if(nums[start] <= nums[mid]){
                ans = Math.min(ans,nums[start]);
                start  = mid + 1;
            }else{
                ans = Math.min(ans,nums[mid]);
                end = mid - 1;
            }
        }
        return ans ;
    }
    public static void main(String[] args) {
        int [] nums = ArrayInp.takeArrayInput();
        System.out.println(findMin(nums));
    }
}
