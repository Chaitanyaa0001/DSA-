package LEETCODE.StackAndQueue.monotonicSandQ;

import java.util.Stack;

public class nextsmallerElement {
    private  static int[] nextSmallerElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            ans[i] = -1;
            for(int j = i + 1; j < n; i++){
                if(curr > nums[j]){
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }
    private static int[] optimalsmallelement(int[] nums){
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for(int i = n-1; i>= 0; i--){
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums  = {4,8,5,2,25};
        nextSmallerElements(nums);
        optimalsmallelement(nums);
    }
}