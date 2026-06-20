package LEETCODE.greedyApproch.easy;

import java.util.*;

public class S3_ShortestJobFirst {
    private static int  shortestjobfirst(int [] b){
            int n = b.length;
            Arrays.sort(b);
            int execution = 0; 
            int time = 0;
        for(int i = 0; i < n ; i++){
            time += execution;
            execution += b[i];
        }
        return time;
    }

    public static void main(String[] args) {
        int [] b = {4,3,7,1,2};
        System.out.println(shortestjobfirst(b));
    }
}