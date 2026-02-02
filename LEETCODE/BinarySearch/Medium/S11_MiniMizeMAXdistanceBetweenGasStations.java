package LEETCODE.BinarySearch.Medium;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;

public class S11_MiniMizeMAXdistanceBetweenGasStations {
    public static double gasstation(int[] nums, int k) {
        int n = nums.length;
        int[] added = new int[n - 1]; // stations added in each gap

        // place k gas stations
        for (int gas = 1; gas <= k; gas++) {
            double maxDist = -1;
            int maxIndex = -1;

            for (int i = 0; i < n - 1; i++) {
                double diff = nums[i + 1] - nums[i];
                double currDist = diff / (added[i] + 1.0);

                if (currDist > maxDist) {
                    maxDist = currDist;
                    maxIndex = i;
                }
            }
            added[maxIndex]++;
        }

        // find final maximum distance
        double ans = 0;
        for (int i = 0; i < n - 1; i++) {
            double diff = nums[i + 1] - nums[i];
            ans = Math.max(ans, diff / (added[i] + 1.0));
        }

        return ans;
    }
    //  priority queue approch 
     static class Pair{
        double dist;
        int  index;
        int segments;
        Pair(double dist, int index, int segments){
            this.dist = dist;
            this.index = index;
            this.segments = segments;
        }
    }
    public static double priority(int [] nums, int k){
        int n = nums.length;
        Queue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.dist, a.dist));
        for(int i = 0; i < n -1; i++){
            pq.offer(new Pair(nums[i+1]-nums[i], i, 1));
        }

        for(int gas = 1; gas <= k; gas++){
            Pair top = pq.poll();
            top.segments++;
            top.dist = (nums[top.index + 1] - nums[top.index]) / top.segments;
            pq.offer(top);
        }
        return pq.peek().dist;
    }
    // optimal ans biary approch 
    public static int countgasstations(int[]nums, long distance){
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n-1; i++){
            double diff = nums[i+1] - nums[i];
            // double gasstation = diff / distance;
            count += (int) diff / distance;
            if(diff % distance == 0) count --;
        }
        return count;
    }
    public static double binary_Approch(int[] nums, int k){
        int n = nums.length;
        long start = 0;
        long end = 0;
        for(int i = 0; i < n-1; i++){
            end = Math.max(end,nums[i+1] - nums[i]);
        }

        while (end -  start > 1000000) {
            long mid = start + (end - start) / 2;

            if(countgasstations(nums, mid) < k){
                end = mid;
            }else{
                start = mid;
            }
        }
        return end;
    }



    public static void main(String[] args) {
        int[] nums = ArrayInp.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
    }
}