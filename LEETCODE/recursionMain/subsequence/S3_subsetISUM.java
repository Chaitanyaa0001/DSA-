package LEETCODE.recursionMain.subsequence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class S3_subsetISUM {
    private static void helper(int i, int sum, int [] nums,List<Integer> list){
        if(i >= nums.length){
            list.add(sum);
            return;   
        }
        helper(i+1, sum + nums[i], nums, list);
        helper(i+1,sum, nums, list);
    }
    private static List<Integer> subsetI(int nums[]){
        List<Integer> result = new ArrayList<>();
        helper(0, 0, nums, result);
        Collections.sort(result);
        
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,4};
        
    }
}