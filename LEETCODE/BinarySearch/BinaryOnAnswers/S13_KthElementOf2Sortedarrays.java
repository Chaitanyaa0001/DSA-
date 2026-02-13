package LEETCODE.BinarySearch.BinaryOnAnswers;
import java.util.*;

import LEETCODE.BinarySearch.ArrayInp;
public class S13_KthElementOf2Sortedarrays {
    public static int binary_ApprochKhelement(int[] a, int[] b, int k){
        int n1= a.length; int n2 = b.length;
        if(n1 > n2) return binary_ApprochKhelement(b, a, k);
        int n = n1 + n2;
        int left = k;
        int low = Math.max(0,  k - n2), high = Math.min(k, n1);
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            if(mid1 < n1) r1 =  a[mid1];
            if(mid2 < n1) r2 =  b[mid1];
            if(mid1 - 1  >= 0) l1 =  a[mid1];
            if(mid2-1 >= 0) l2 =  a[mid1];

            if(l1 < r2 && l2 < r1){
                return Math.max(l1, l2);
            }else if(l2 > r1){
                low = mid1 + 1;
            }else{
                high = mid1 - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] nums = ArrayInp.takeArrayInput();

    }
}