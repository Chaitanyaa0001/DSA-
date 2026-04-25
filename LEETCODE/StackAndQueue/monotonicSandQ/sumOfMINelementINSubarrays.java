package LEETCODE.StackAndQueue.monotonicSandQ;

import java.util.Stack;

public class sumOfMINelementINSubarrays {
    private static int brute(int[] nums){
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int min = nums[i];
            for(int j = i; j < n; j++){
                min = Math.min(min, nums[j]);
                sum += min;
            }
        }
        return sum;
    }

    
    private static int[] pse(int[] nums){
        int n = nums.length;
        int [] a = new int[n];
        Stack<Integer> stack  = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                a[i] = -1;
            }else{
                a[i] = stack.peek();
            }
            stack.push(i);
        }
        return a;
        // {3,1,2,4}
    }

    private static int[] nse(int[] nums){
        int n = nums.length;
        int [] b = new int[n];
        Stack<Integer> stack  = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                b[i] = n;
            }else{
                b[i] = stack.peek();
            }
            stack.push(i);
        }
        return b;
        // {3,1,2,4}
    }
    private static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int pse[] = pse(arr);
        int nse[] = nse(arr);

        long ans = 0;
        long MOD = 1000000007;
        
        for(int i = 0; i < n; i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            long contri = ((long)arr[i] * left % MOD ) * right % MOD;
            ans = (ans + contri) %  MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int [] arr  = {3,1,2,4};
        sumSubarrayMins(arr);
        brute(arr);
    }
}
