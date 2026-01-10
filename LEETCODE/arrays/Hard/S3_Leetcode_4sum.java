package LEETCODE.arrays.Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.*;

import LEETCODE.arrays.ArrayInput;

public class S3_Leetcode_4sum {
    public static List<List<Integer>> bruteforce(int[] nums, int target){
        HashSet<List<Integer>>  set =  new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i +1; j < n; j++){
                for(int k = j+1; j < n; k++){
                    for(int l = k+1; l < n; l++){
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target ){
                            List<Integer> list  = Arrays.asList(nums[i], nums[j], nums[k],nums[l]);
                            Collections.sort(list);
                            set.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> betterapproch(int[] nums, int target){
        int n = nums.length;
        HashSet<List<Integer>> ans = new HashSet<>();

        for(int i = 0 ; i < n ;i++){
            for(int j = i+1; j < n; j++){
                HashSet <Integer> temp = new HashSet<>();
                for(int k = j+1; k < n; k++){
                    int fourth = target - nums[i] + nums[j] + nums[k];
                    if(temp.contains(fourth)){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k],fourth);
                        Collections.sort(list);
                        ans.add(list);
                    }
                    temp.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(ans);
    }
    public static void main(String[] args) {
        int [] nums = ArrayInput.takeArrayInput();

    }
}
