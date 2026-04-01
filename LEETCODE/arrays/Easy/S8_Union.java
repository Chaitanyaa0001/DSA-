import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import LEETCODE.arrays.ArrayInput;

public class S8_Union {
    // O(n + m)
    // O(k log k)

    // O(n + m + k log k)

    private static int[] findUnionfromarrays(int[] num1, int[] num2){
        HashSet<Integer> union = new HashSet<>();
        // O(n) 
        for(int i = 0; i < num1.length; i++){
            union.add(num1[i]);
        }
        // o(n) 
        for(int i = 0; i < num2.length; i++){
            union.add(num2[i]);
        }
        int result [] = new int[union.size()];
        int i = 0;
        // O(n+m) 
        for(int num : union){
            result[i++] = num;
        }
        // return union.stream().sorted().mapToInt(i -> i).toArray();
        return result;

    }

    private static int[]  optimalApproch(int[] nums1, int [] nums2){
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums1.length, m =  nums2.length;
        while (i < n && j < m) {
            if(nums1[i] <nums2[j]){
                if( list.size() == 0 || list.get(list.size() - 1) != nums1[i]){

                    list.add(nums1[i]);
                }
                i++;
            }else{
                if(list.size() == 0 || list.get(list.size() - 1) != nums2[j]){
                    list.add(nums2[j]);
                }
                j++;

            }
        }
        
        while (i < n) {
            if( list.size() == 0 || list.get(list.size() - 1) != nums1[i]){

                    list.add(nums1[i]);
                }
                i++;
        }
        while (j < m) {
            if(list.size() == 0 || list.get(list.size() - 1) != nums2[j]){
                    list.add(nums2[j]);
                }
                j++;
            
        }
        int[] ans = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(k);
        }

        return ans;
    }
    public static void main(String[] args) {
        // num {1,2,8,3,4,5} 
        // num2 {1,2,7}
        int[] num1 = ArrayInput.takeArrayInput();
        int[] num2 = ArrayInput.takeArrayInput();
         int[] result = findUnionfromarrays(num1, num2);
         optimalApproch(num1, num2);
        for (int i : result) {
            System.out.println(i+ " ");
        }

    }
}
