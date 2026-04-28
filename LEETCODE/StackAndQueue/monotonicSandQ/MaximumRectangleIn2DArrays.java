package LEETCODE.StackAndQueue.monotonicSandQ;

import java.util.Stack;

public class MaximumRectangleIn2DArrays {
    private static int  histogram(int[]a){
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
    private static int maxrec(int [][] a){
        int n = a.length;
        int m = a[0].length;
        int prefix[][] = new int[n][m];
        for(int col = 0; col < m; col++){
            int sum = 0;
            for(int row = 0; row < n; row++){
                 sum += prefix[row][col];
                 if(a[row][col] == 0){
                    sum = 0;
                 }
                 prefix[row][col] = sum;
            }
        }
        int maxarea = 0;
        for(int i = 0; i < n; i++){
            maxarea +=  Math.max(maxarea,histogram(prefix[i]));
        }
        return maxarea;
    }
    public static void main(String[] args) {
        int a[][] = {{1,0,1,0,1},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        maxrec(a);
    }
}
