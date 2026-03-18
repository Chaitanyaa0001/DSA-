package LEETCODE.recursionMain.Problems;

import java.util.ArrayList;
import java.util.List;

public class PrintSubSequence {
    private static void subseq( int index,int[] arr ,List<Integer> list, int n){
        if(index >= n){
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        subseq(index+1, arr, list, n);
        list.remove(list.size() - 1);
        subseq(index+1, arr, list, n);
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        subseq(0, arr,  new ArrayList<>(), arr.length);
    }
}
