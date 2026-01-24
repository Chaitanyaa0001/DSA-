package LEETCODE.BinarySearch.Easy;
// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:
// Input: nums = [1], target = 0
// Output: -1
// Constraints:
// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// All values of nums are unique.
// nums is an ascending array that is possibly rotated.
// -104 <= target <= 104

import LEETCODE.BinarySearch.ArrayInp;
public class S8_Leetcode_33_SortedInRotatedArray {
    public static int seacth(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (end >= start) {
            int mid = start + (end - end) / 2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[start] <= nums[mid] ){
                if(nums[start] <= target && target <= nums[mid]){
                    end  = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // nums = [4,5,6,7,0,1,2], target = 0 output = 4;
        //  nums = [4,5,6,7,0,1,2], target = 3 output -1;
        int [] nums = ArrayInp.takeArrayInput();

        System.out.println(seacth(nums, 3));
    }
}
