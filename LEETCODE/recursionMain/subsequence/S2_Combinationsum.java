package LEETCODE.recursionMain.subsequence;
// without duplicates 
//  more than choise for loop and sub sequence 

import java.util.ArrayList;
import java.util.List;

public class S2_Combinationsum {
    private static void helper(int index, int tagret, int nums[], List<Integer> list, List<List<Integer>> result){
        if( tagret == 0){
            result.add(new ArrayList<>(list));
        }

        for(int  i = 0; i < nums.length; i++){
            // avoid uplicates 
            if(i > index && nums[i] == nums[i-1]) continue;
            if(nums[i] > tagret) break;
            list.add(nums[i]);
            helper(i + 1, tagret - nums[i], nums, list, result);
            list.remove(list.size() - 1);

        }
    }

    private static List<List<Integer>> mainfunction(int nums[], int target){
    List<List<Integer>> result = new ArrayList<>();
        helper(target, target, nums, new ArrayList<>(), result);
    return result;
    }
    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2};
        mainfunction(nums, 4);
    }
}
