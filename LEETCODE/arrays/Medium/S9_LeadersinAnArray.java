package LEETCODE.arrays.Medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

import LEETCODE.arrays.ArrayInput;

public class S9_LeadersinAnArray {
    public static List<Integer> leaders(int[] nums){
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

    public static void main(String[] args) {
        int [] nums= ArrayInput.takeArrayInput();
        List<Integer> hm = leaders(nums);
         System.out.println(hm);
    }
}