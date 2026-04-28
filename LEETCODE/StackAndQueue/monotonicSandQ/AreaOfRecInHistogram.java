package LEETCODE.StackAndQueue.monotonicSandQ;

import java.util.Stack;

public class AreaOfRecInHistogram {
    private static int maxareaofhistogram(int a[]){
         Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && a[stack.peek()] > a[i] ){
                int ele = stack.pop();
                int nse = i;
                int pse = (stack.isEmpty()) ? -1 : stack.peek();
                maxArea = Math.max(maxArea,(nse - pse -1) * a[ele]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int ele = stack.pop();
                int nse = n;
                int pse = (stack.isEmpty()) ? -1 : stack.peek();
                maxArea = Math.max(maxArea,(nse - pse -1) * a[ele]);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int a[]  = {6,2,3,4,5,6,2,4,5,2};
        maxareaofhistogram(a);
    }
}