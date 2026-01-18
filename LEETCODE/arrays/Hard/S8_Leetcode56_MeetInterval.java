package LEETCODE.arrays.Hard;

import LEETCODE.arrays.ArrayInput;

import java.util.*;
public class S8_Leetcode56_MeetInterval {
    public static int[][] brute(int[][] interval){

        Arrays.sort(interval, (a,b) -> a[0] - b[0]);
        int n = interval.length;
        for(int i = 0 ; i < n; i ++){
            int start = interval[i][0];
            int end = interval[i][1];

        }
    }
    public static void main(String[] args) {
        int [] nums  = ArrayInput.takeArrayInput();  
    }
}