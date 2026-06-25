package LEETCODE.greedyApproch.easy;

import java.util.*;

public class S9_InsertIntervals {
    private static int[][] insertinterval(int[][]intervals, int newInterval[]){

        int n = intervals.length;
            // {{1,2},{3,5},{6,7},{8,10},{12,16}};
            // {3,10} {12,16}

        List<int[]> list = new ArrayList<>();
            
        for(int i = 0; i < n; i++){
            // left 
            if(intervals[i][1] < newInterval[0]){
                list.add(intervals[i]);
            }else if( newInterval[1] < intervals[i][0]){
                list.add(newInterval);
                newInterval= intervals[i];
            }else{
                intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
                intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        return list.toArray(new int[list.size()][]); 
    }
    public static void main(String[] args) {
        int [][] intervals = {{1,2},{3,5},{6,7},{8,9},{12,16}};
        int[] newInterval = {4,8};
        insertinterval(intervals, newInterval);

    }
}
