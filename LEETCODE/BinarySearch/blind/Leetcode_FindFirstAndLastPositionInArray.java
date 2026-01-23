package LEETCODE.BinarySearch.blind;

import LEETCODE.BinarySearch.ArrayInp;

public class Leetcode_FindFirstAndLastPositionInArray {
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
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }
        int last = upper(nums, target) - 1;
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int [] nums =  ArrayInp.takeArrayInput();
        int taget = 8;

        System.out.println(searchRange(nums, taget));
    }
}
