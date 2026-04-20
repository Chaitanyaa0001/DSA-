package LEETCODE.StackAndQueue.monotonicSandQ;

import java.util.Stack;

public class nearestSmallerElement {
    private static int[] bruteforcetofindnearestelement(int[] nums){
        int n = nums.length;
        // time complexity is O(n2)
        int[] ans = new int[n];
        for(int i = n-1 ; i >= 0; i--){
            ans[i] = -1;
            for(int j = i + 1; j >= 0; i++){
                if(nums[i] >= nums[j]){
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }

    private static int[] optimalFindNearestElement(int[] nums){
        // time : O(2N) 
        // space : O(n) + O(n)
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.pop();
            }
            stack.push(nums[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,9,6,7,4,5,1,3,7};
        bruteforcetofindnearestelement(nums);
        optimalFindNearestElement(nums);
    }
}
