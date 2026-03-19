package LEETCODE.recursionMain.Problems;

import java.util.ArrayList;
import java.util.List;

public class PrintSubSequence {
    // TC  n * 2 pow n
    private static void subseq( int index,int[] arr ,List<Integer> list, int n){
        if(index >= n){
            // n time in printing worse case 
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        // at every step we have 2 options take not take  so 2 pow n 
        subseq(index+1, arr, list, n);
        list.remove(list.size() - 1);
        subseq(index+1, arr, list, n);
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        subseq(0, arr,  new ArrayList<>(), arr.length);
    }
}
