package LEETCODE.arrays.Medium;
public class S8_Leetcode_Npermumatation {
    // in this we have to find the next permutation as for array {1,2,3}
    //  the comibnations can be 
    // {1,2,3} 
    // {1,3,2}
    // {2,1,3}
    // {2,3,1}
    // {3,1,2} this is given and the next permutaion is 
    // {3,2,1} .....

    // edge case for { 3,2,1} in such cases we can go back to [1,2,3]
    private static int[] optimal(int a[]){
        int index = -1; 
        int n  = a.length;
        for(int i = n-2; i >= 0; i--){
            if(a[i] < a[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(a, 0, n-1);
            return a;
        }
        // now we have to find the elemet which is greater than index but the smallest one 
        // index = 1
        // then we have to calcule less than this 
        for(int i = n-1; i >= 0; i--){
            if(a[i] > a[index]){
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
                break;
            }
        }

        // now revsere after breakpoint
        reverse(a, index+1, n-1);
        return a;

        // time : O(n);
        // space O(n);

    }
    private static void  reverse(int a[], int start, int end){
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start ++;
            end--;
        }
    }
    
    
    public static void main(String[] args) {
          int arr[] = {3,1,2};
          optimal(arr);

    }
}
