package LEETCODE.BinarySearch.BinaryOn1DArray;

import LEETCODE.BinarySearch.ArrayInp;

public class S7_countOccurenceofElement {
    public static int lower(int[] nums, int target){
        int ans = nums.length;
        int n = nums.length;
        int start = 0; 
        int end = n -1;
        while (start <= end) {
            int mid = start +  (end - start) / 2;
            if(nums[mid] >= target){
                ans = mid;
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    } 
    public static int upper(int[] nums, int target){
        int ans = nums.length;
        int n = nums.length;
        int start = 0; 
        int end = n -1;
        while (start <= end) {
            int mid = start +  (end - start) / 2;
            if(nums[mid] > target){
                ans = mid;
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }

    public static int[] maincall(int nums[] , int target){
        int first = lower(nums, target);
        if(first == nums.length || nums[first] != target){
            return new int[]{-1,-1};
        }
        int second = upper(nums, target) - 1;

        return new int[]{first,second};
    }

    public static int occurence(int[] nums, int target){
        int arr[] = maincall(nums, target);
        if(arr[0] == -1)return 0;

        return arr[1] - arr[0] + 1;
    }

    public static void main(String[] args) {
        int [] nums = ArrayInp.takeArrayInput();

        // int[] res = maincall(null, 0);

        System.out.println(occurence(nums, 5));



    }
}
