package LEETCODE.StackAndQueue.monotonicSandQ;

import java.util.HashMap;
import java.util.Stack;


public class nextGreaterElement {
    private static int[] nextgelem(int[] nums1, int[] nums2){
        int ans[]  = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int x = nums1[i];
            int j = 0;

            while(nums2[j] != x){
                j++;
            }
            int nge = -1;
            for(int k = j+1; k < nums2.length;k++){
                if(x < nums2[k]){
                    nge = nums2[k];
                    break;
                }
            }
            ans[i] = nge;
        }
        return ans;
    }

    private static int[] optimal(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();

        HashMap<Integer,Integer> map = new HashMap<>();
        return new int[]{1,1};
    }
    public static void main(String[] args) {
        nextgelem(null, null);
        optimal(null, null);
    }
}