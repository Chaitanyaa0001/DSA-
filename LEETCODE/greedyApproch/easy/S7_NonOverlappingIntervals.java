package LEETCODE.greedyApproch.easy;

import java.util.Arrays;

public class S7_NonOverlappingIntervals {

    private static int eraseIntervals(int intervals[][]){
        int n = intervals.length;
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
        int count = 0;
        int endingInterval = intervals[0][1]; // 2
        for(int i = 1; i < n; i++){
            int startinterval = intervals[i][0];
            if(endingInterval > startinterval){
                count++;
            }else{
                endingInterval = intervals[i][1];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int a[][] = {{1,2},{2,3},{3,4},{1,3}};
        
    }
}
