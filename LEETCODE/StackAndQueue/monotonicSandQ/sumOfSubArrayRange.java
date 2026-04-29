package LEETCODE.StackAndQueue.monotonicSandQ;

import java.util.Scanner;
import java.util.Stack;

public class sumOfSubArrayRange {

    private static int bruteforce(int[] a){
        int n = a.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            int largest = a[i] , smallest = a[i];
            for(int j = 0; j < n; j++){
                largest = Math.max(largest, a[j]);
                smallest = Math.min(smallest,a[i]);
                sum += (largest - smallest);
            }
        }
        return sum;
        // time  - O(n2)
        // space  - O(1)
    }

    // --------------------------------------------------------------------------------------------------------------

    private static int[] nextSamllerElement(int a[]){
        // min 
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans  = new int[n];
        // {3,4,3,5,26,7,12,2}
        for(int i = n-1; i >= 0; i--){
            while (!stack.isEmpty() && a[stack.peek()] > a[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = n;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] previousSamllerElement(int a[]){
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans  = new int[n];
        // {3,4,3,5,26,7,12,2}
        for(int i = 0; i < n; i++){
            while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
   
    private static int[] nextGreaterElement(int a[]){
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans  = new int[n];
        // {3,4,3,5,26,7,12,2}
        for(int i = n-1; i >= 0; i--){
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = n;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] previousGreaterElement(int a[]){
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans  = new int[n];
        // {3,4,3,5,26,7,12,2}
        for(int i = 0; i < n; i++){
            while (!stack.isEmpty() && a[stack.peek()] <= a[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static long  calculateLargest(int[] a){
        int[] nge = nextGreaterElement(a);
        int[] pge = previousGreaterElement(a);
        long sum = 0;
        for(int i = 0; i < a.length; i++){
            int left = i - pge[i];
            int right = nge[i] - i;
            long freq = 1L * left * right;
            sum += freq * a[i];
        }
        return sum;
    }

    private static long  calculateSmallest(int[] a){
        int[] nse = nextSamllerElement(a);
        int[] pse = previousSamllerElement(a);
        long sum = 0;
        for(int i = 0; i < a.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = 1L * left * right;
            sum += freq * a[i];
        }
        return sum;
    }
    public static  long OPTIMALsubArrayRanges(int[] a) {
        return calculateLargest(a) - calculateSmallest(a);
    }


 public static void main(String[] args) {
    Scanner sc  = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];
    for(int i = 0 ; i < n; i++){
        a[i] = sc.nextInt();
    }
    bruteforce(a);
    OPTIMALsubArrayRanges(a);

 }   
}
