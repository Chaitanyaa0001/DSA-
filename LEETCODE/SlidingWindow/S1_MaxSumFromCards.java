package LEETCODE.SlidingWindow;

import java.util.Scanner;

public class S1_MaxSumFromCards {
    // we  can pick  from begninning and back 
    private static int maxsumcards(int a[], int k){
        int maxlen =0; 
        int n = a.length;
        int leftsum = 0; int rightsum = 0;
        for(int i = 0; i < n; i++){
            // {1,2,3,4,5,6,1}
            leftsum += a[i];
        }
        maxlen = leftsum;
        // l = 1,2,3     r = 1
        int r = n - 1;
        for(int i = n-1; i >= 0; i--){
            leftsum -= a[i];
            rightsum += a[r];
            r--;
            maxlen = Math.max(maxlen,leftsum+rightsum);
        }
        return maxlen;
    }
    public static void main(String[] args) {
        //  There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
        // In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
        // Your score is the sum of the points of the cards you have taken.
        // Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
        int a[] = {1,2,3,4,5,6,1};
        Scanner sc =  new Scanner(System.in);
        int k =  sc.nextInt();
        maxsumcards(a, k);
    }
}