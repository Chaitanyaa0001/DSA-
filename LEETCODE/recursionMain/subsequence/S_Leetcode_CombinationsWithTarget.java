package LEETCODE.recursionMain.subsequence;

import java.util.*;;
public class S_Leetcode_CombinationsWithTarget {
    private  static  void helper(int i, int target,int arr[] ,List<Integer> list, List<List<Integer>> result){
        if(i  ==  arr.length){
            if(target == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[i] <= target){
            list.add(arr[i]);
            helper(i, target - arr[i], arr, list, result);
            list.remove(list.size() - 1);
        }
        helper(i+1, target, arr, list, result);
    }

    private static List<List<Integer>> countcombination(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        helper(0, target, nums, new ArrayList<>(), result);
        return result;

    }
    public static void main(String[] args) {
        int [] nums = {2,3,6,7};
        countcombination(nums, 7)   ;
    }
} 