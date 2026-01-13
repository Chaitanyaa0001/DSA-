package LEETCODE.arrays.Hard;

import LEETCODE.arrays.ArrayInput;

import java.util.*;
public class S8_Leetcode56_MeetInterval {
    public static int[][] brute(int[][] interval){
        
         Arrays.sort(interval, (a, b) -> a[0] - b[0]);
         int n  = interval.length;
         List<int[]> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
           int start = interval[i][0];
           int end = interval[i][1];
           if(!ans.isEmpty() && end <= ans.get(ans.size()-1)[1]){
            continue;
           }
           for(int j = i+1; j < n; j++){
               if(interval[j][0] <= end){
                   end = Math.max(end, interval[j][1]);
               }else{
                   break;
               }
            }
            ans.add(new int[]{start,end});
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int [] nums  = ArrayInput.takeArrayInput();  
    }
}