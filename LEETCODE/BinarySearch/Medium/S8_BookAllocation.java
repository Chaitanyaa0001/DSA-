package LEETCODE.BinarySearch.Medium;

import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;

public class S8_BookAllocation {
    
    public static long allocateBooks(long[] books, int N, int M) {
        if (N < M) return -1;
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (long b : books) {
            max = Math.max(max, b);
            sum += b;
        }
        long start = max, end = sum;
        while (start <= end){
            long mid = start + (end - start) / 2 ;
            
            if(checkStudents(books,mid) <= M){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        } 
        return start;
    }

    public static int checkStudents(long[] nums, long pages) {
        int students = 1;
        long pageT = 0;

        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] > pages) return Integer.MAX_VALUE;

            if (pageT + nums[i] <= pages) {
                pageT += nums[i];
            } else {
                students++;
                pageT = nums[i];
            }
        }
        return students;
    }
    public static void main(String[] args) {
    
        int [] nums = ArrayInp.takeArrayInput();
        Scanner sc  = new Scanner(System.in);
        int M = sc.nextInt();
    }
}
