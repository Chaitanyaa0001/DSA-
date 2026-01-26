package LEETCODE.BinarySearch.Easy;

public class S11_FindLengthofRotattion {
    public static int findRotation(int nums[]){
        int n = nums.length;
        int start = 0; 
        int end = n - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (end >= start) {
            int mid = start + (end - start) / 2;

            if(nums[start] <= nums[mid]){
                if(nums[start] < ans){
                    ans = nums[start];
                    index S12= start;
                }
                start = mid + 1;
            }else{
                if(nums[mid] < ans){
                    ans = nums[mid];
                    index = mid;
                }
                end = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        
    }
}
