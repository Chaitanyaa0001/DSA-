package LEETCODE.greedyApproch.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S10_MergeInterval {
        private  static int[][] merge(int[][] intervals) {

        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int[] current = intervals[0];   // i = 0  // {1,3}
        for(int i = 1; i < n; i++){
            if( intervals[i][0] <= current[1]){
                current[1] = Math.max(intervals[i][1],current[1]);  // {1,6}
            }else{
                ans.add(current);
                current = intervals[i];   
            }
        } 
        ans.add(current);

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        
        merge(null);
    }
}
