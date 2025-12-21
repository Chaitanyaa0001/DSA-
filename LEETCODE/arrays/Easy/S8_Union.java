import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import LEETCODE.arrays.ArrayInput;

public class S8_Union {
    // O(n + m)
    // O(k log k)

    // O(n + m + k log k)

    public static int[] findUnionfromarrays(int[] num1, int[] num2){
        HashSet<Integer> union = new HashSet<>();
        for(int i = 0; i < num1.length; i++){
            union.add(num1[i]);
        }
        for(int i = 0; i < num2.length; i++){
            union.add(num2[i]);
        }

        return union.stream().sorted().mapToInt(i -> i).toArray();

    }

    public static int[]  optimalApproch(int[] nums1, int [] nums2){
        int i = 0;
        int j = 0;
        // ArrayList<Integer> list = new ArrayList<>();
        int temp[] = new int[nums1.length + nums2.length];
        int x  = 0;
        while (i < nums1.length && j < nums2.length) {
            // if( nums1[i] == list.contains(nums1[i]))
            if(nums1[i] <= nums2[j] ){
                // list.add(nums1[i++]);
                if(nums1[i] != temp[x]){
                    temp[x]  = nums1[i];
                }
                i++;
                x++;
            }else if(nums1[i] >= nums2[j]){
                // list.add(nums2[j++]);
                if(nums2[j] != temp[x]){
                    temp[x]  = nums2[j];
                }
                j++;
                j++;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        // num {1,2,8,3,4,5} 
        // num2 {1,2,7}
        int[] num1 = ArrayInput.takeArrayInput();
        int[] num2 = ArrayInput.takeArrayInput();
         int[] result = findUnionfromarrays(num1, num2);
        for (int i : result) {
            System.out.println(i+ " ");
        }

    }
}
