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

        return -1;
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
        int n1 = nums1.length;
        int n2 = nums2.length;
        // we have to take the short array so that we can reduce the time complexity 
        if ( n1 > n2) return binary_Approch(nums2, nums1);
        // total array length 
        int n = n1 + n2;
        // this is how many elements should be there on the left side of the array 
        int left = (n1 + n2 + 1) / 2;
        int  start = 0, end = n1 ;

        while (start <= end) {
            int mid1 = start + (end - start) / 2;
            int mid2 = left - mid1;
            // if value is not there then we in left we have to take the max element 
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
        //    if value is not there on right then we have to take the min element  
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            // check that our all elements l1,l2,r1,r2 lies between the boundries 
            if( mid1 < n1) r1 = nums1[mid1]; //  r1 should be in the range of array 1 of right side  r1 < n1
            if( mid2 < n2) r2 = nums2[mid2]; // r2 should be in the range of array 2 of right side r2 < n2
            if(mid1 -1 >= 0) l1 = nums1[mid1-1]; // l1 should exist in the range it should not end up at -1 hypothetical index l1 >= 0
            if(mid2 -1 > 0) l2 = nums2[mid2 -1]; // l1 should exist in the range it should not end up at -1 hypothetical index l1 >= 0

            // if our this condition meets then our array is this 
            if(l1 < r2 && l2 < r1){
                // check for if our array is odd then we need to find the max of l1 and l2 beacuse it will be our median 
                if(n % 2 == 1){
                    return Math.max(l1, l2);
                } else{
                    // for odd we will take max elenet from left side and min element from right side  and take  median 
                  return  (Math.max(l1,l2) + Math.min(r1, r2)) / 2;
                }    
            }else if( l2 > r1){
                start = mid1 + 1;
            }else{
                end = mid1 - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int [] nums = ArrayInp.takeArrayInput();
        
    }
}