package LEETCODE.BinarySearch.BinaryOnAnswers;

import java.util.ArrayList;
import java.util.List;

import LEETCODE.BinarySearch.ArrayInp;

public class S12_Leetcode_MedianOfTwoSortedArrays {
    public static int brute_force(int[] nums1, int[] nums2){
        int N = nums1.length;
        int M = nums2.length;
        int n = N + M;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int  j = 0;

        while ( N > i && M > j) {
            if(nums1[i] < nums2[j]){
                list.add(nums1[i]++);
            }else{
                list.add(nums2[j++]);
            }
        }
        while ( N >= i) {
            list.add(nums1[i]++);
        }
        while (M > j) {
            list.add(nums2[j++]);
        }
        int k = list.size();

        if (k % 2 == 0){
             return (list.get(k / 2) + (k / 2 -1)) / 2;
        }
        if( k % 2 == 1){
            return list.get(k/2);
        }
    }

    public static int betterApproch(int[] nums1, int[] nums2){
        int p = nums1.length;
        int q  = nums2.length;
        int n = p + q;
        int index1 = n / 2;
        int index2 = index1 - 1;
        int element = -1, element2 = -1;
        int i = 0;
        int j = 0;
        int count = 0;
        while (p > i &&  q > j) {
            if(nums1[i] < nums2[j]){
                if(count == index1) element =  nums1[i];
                if(count == index2) element2 = nums1[i];
                i++;
                count++;
            }else{
                if(count == index1) element =  nums2[j];
                if(count == index2) element2 = nums2[j];
                i++;
                count++;
            }
        }

        while (p > i) {
            if(count == index1) element =  nums1[i];
            if(count == index2) element2 = nums1[i];
            i++;
            count++;
        }
        
        while (q > j) {
            if(count == index1) element =  nums2[j];
            if(count == index2) element2 = nums2[j];
            i++;
            count++;
        
        }

        if ( n % 2 == 0){
            return element + element2 / 2;
        }
        if(n % 2 == 1){
            return element;
        }

        return  -1;
    }

    public static int  binary_Approch(int[] nums1, int[] nums2){
        
        return -1;
    }

    
    public static void main(String[] args) {
        int [] nums = ArrayInp.takeArrayInput();
        
    }
}