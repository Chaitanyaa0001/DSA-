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


    public static List<List<Integer>> optimalapproch(int[] nums, int target){
        int n = nums.length;
        HashSet<List<Integer>> ans = new HashSet<>();

        Arrays.sort(nums);

        for(int i = 0; i < n; i ++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                int start = j+1;
                int end = n-1;
                while (end > start) {
                    int sum = nums[i] + nums[j] +  nums[start] + nums[end];
                    if(sum < target){
                        start++;
                    }else if(sum > target){
                        end--;
                    }else{
                        List<Integer> list =  Arrays.asList(nums[i],nums[j],nums[start],nums[end]);
                        ans.add(list);
                        start++;
                        end--;
                        while ( end > start && nums[start] == nums[start-1]) {
                            start++;
                        }
                        while ( end > start && nums[end] == nums[end+1]) {
                            end--;
                        }
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        int [] nums = ArrayInput.takeArrayInput();


        System.out.println(bruteforce(nums, 0));;
        System.out.println(betterapproch(nums, 0));
        System.out.println(optimalapproch(nums, 0));

    }
}
