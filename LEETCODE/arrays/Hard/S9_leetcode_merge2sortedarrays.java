package LEETCODE.arrays.Hard;

import java.util.Arrays;
import java.util.Scanner;

import LEETCODE.arrays.ArrayInput;

public class S9_leetcode_merge2sortedarrays {
    public static void  optimal(int[] nums1, int m, int[] nums2, int n){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i >= 0 &&  j >= 0){
            if(nums1[i] <= nums2[j]){
                nums1[k--] = nums2[j--];
            }else{
                nums1[k--] = nums1[i--];
            }
        }

        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums1 = ArrayInput.takeArrayInput();
        int  m = sc.nextInt();
        int[] nums2 = ArrayInput.takeArrayInput();
        int n = sc.nextInt();

        optimal(nums1, m, nums2, n);
    }
}
