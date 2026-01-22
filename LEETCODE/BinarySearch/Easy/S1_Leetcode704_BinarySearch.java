package LEETCODE.BinarySearch.Easy;
import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;
public class S1_Leetcode704_BinarySearch {

    public static int brute(int[]nums, int target){

        int n = nums.length;
        int start = 0;
        int end = n-1;
        while (end >= start) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid +1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] nums = ArrayInp.takeArrayInput();
        int target =  sc.nextInt();
        System.out.println(brute(nums, target));
    }
}
