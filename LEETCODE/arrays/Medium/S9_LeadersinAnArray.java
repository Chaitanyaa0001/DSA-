package LEETCODE.arrays.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import LEETCODE.arrays.ArrayInput;

public class S9_LeadersinAnArray {
    private static List<Integer> leaders(int[] nums){
        ArrayList <Integer> list = new ArrayList<>();
        int n = nums.length;
        int elem= nums[n-1];
        list.add(elem);

        for(int i  = n-2; i >=0; i-- ){
            if(nums[i] > elem  ){
                list.add(nums[i]);
                elem = nums[i];
            }
        }
        Collections.reverse(list);
        return list;
    }

    private static int [] bruteForce(int a[]){
        int n = a.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            boolean leader = true;
            for(int j = i+1; j < n; j++){
                if(a[i] < a[j]){
                    leader = false;
                    break;
                }
            }
            if(leader == true){
                list.add(a[i]);
            }
        }
        return list.stream().mapToInt(Integer:: intValue).toArray();
    }

    public static void main(String[] args) {
        int [] nums= ArrayInput.takeArrayInput();
        List<Integer> hm = leaders(nums);
        bruteForce(nums);
         System.out.println(hm);
    }
}