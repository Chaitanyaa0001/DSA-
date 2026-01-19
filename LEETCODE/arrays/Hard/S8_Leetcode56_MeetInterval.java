package LEETCODE.arrays.Hard;

import LEETCODE.arrays.ArrayInput;

import java.util.*;
public class S8_Leetcode56_MeetInterval {
    public static int[][] brute(int[][] interval){

        List<int[]> ans = new ArrayList<>();

        Arrays.sort(interval, (a,b) -> a[0] - b[0]);
        int n = interval.length;
        for(int i = 0 ; i < n; i ++){
            int start = interval[i][0];
            int end = interval[i][1];

            if(ans.isEmpty() || interval[i][1] < ans.get(ans.size() -1)[1]){
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

        return ans.toArray(new int[ ans.size()][]);
    }


    public static int[][] optimalapproch(int[][] interval){
        int n =interval.length;
        Arrays.sort(interval,(a,b) -> a[0] - b[0]);
        List<int[]> ans =  new ArrayList<>();
        for(int i  = 0; i < n; i ++){
            if(ans.isEmpty() || ans.get(ans.size()-1)[1] < interval[i][0]){
                ans.add(new int[] {interval[i][0], interval[i][1]});
            }else{
                ans.get(ans.size()-1)[1] =  Math.max(ans.get(ans.size()-1)[1], interval[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int [] interval  = ArrayInput.takeArrayInput();  

        System.out.println(brute(null));
        System.out.println(optimalapproch(null));
    }
}