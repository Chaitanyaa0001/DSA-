package LEETCODE.arrays.Hard;

import LEETCODE.arrays.ArrayInput;

public class S11_CountInversions {

    public static int bruteforce(int[] nums){
        int n = nums.length;
        int count  = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] > nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    // to find optimal we need to apply the merge sort algorithm 
    public static int optimal(int[] nums, int start,  int mid , int end){
        int count = 0;
        int ptr1 = start;
        int ptr2 =  mid +1;
        int[] temp =  new int[nums.length];
        int x = 0;

        while ( ptr1 <= mid && ptr2 <= end) {
            if(nums[ptr1] < nums[ptr2] ){
                temp[x++] =  nums[ptr1++];
            }else{
                count += (mid - ptr1 + 1);
                temp[x++] =  nums[ptr2++];
            }
        }
        while (ptr1 <= mid) {
            temp[x++] =  nums[ptr1++];
        }
        while (ptr2 <= end) {
            temp[x++] =  nums[ptr2++];
        }

        for(int i = start; i <= end; i++){
            nums[i] = temp[i-start];
        }

        return count;
    }
    public static int  mergesort(int[] nums , int start, int end){
        int count = 0;
        if(end <= start) return 0;
        int mid = start + (end-start)/2;
        count += mergesort(nums, start, mid);
        count += mergesort(nums, mid+1, end);
        count += optimal(nums, start, mid, end);

        return count;
    }
    public static void main(String[] args) {
        //  {5,3,2,4,1} count = 8 total number of 8 pairs in which nums[i] > nums[j] 
        int[] nums = ArrayInput.takeArrayInput();
        // System.out.println( "count :" + bruteforce(nums));
        System.out.println(mergesort(nums, 0, nums.length-1));
    }
}
