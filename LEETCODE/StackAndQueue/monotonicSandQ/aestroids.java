package LEETCODE.StackAndQueue.monotonicSandQ;

import java.util.Stack;

public class aestroids {
    private static int[] asteroidCollision(int nums[]){
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            // agar positive element hai to 
            if(nums[i] > 0){
                stack.push(nums[i]);
                
            }else{
                // ab agar negtive elemnt mil gya 
                while (!stack.isEmpty() && nums[i] < 0 && stack.peek() > 0 && stack.peek() < Math.abs(nums[i])) {
                    stack.pop();
                }
                // agar dono equal 
                if(!stack.isEmpty() && stack.peek() == -nums[i]){
                    stack.pop();
                    // or agar end mei -ve elemnts pachte hai to 
                }else if (stack.isEmpty() || stack.peek() < 0){
                    stack.push(nums[i]);
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] aestorids = {3,5,-6,2,-1,4};
        asteroidCollision(aestorids);
    }
}
    