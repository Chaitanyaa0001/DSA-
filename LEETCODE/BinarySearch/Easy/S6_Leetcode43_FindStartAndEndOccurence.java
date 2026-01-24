package LEETCODE.BinarySearch.Easy;

import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.
// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]
// Constraints:
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109

public class S6_Leetcode43_FindStartAndEndOccurence {
    public static int lower(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = nums.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    public  static int upper(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = nums.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = lower(nums, target);
        if (first == nums.length || nums [first]!= target) {
            return new int[]{-1, -1};
        }
        int last = upper(nums, target) - 1;
        return new int[]{first, last};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] nums = ArrayInp.takeArrayInput();
        int target = sc.nextInt();

        int[] res = searchRange(nums, target);

        for(int i = 0; i <= res.length;i++){
            System.out.print(res[i]+ " ");
        }
    }
}