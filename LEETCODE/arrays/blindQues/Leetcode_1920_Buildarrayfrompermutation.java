package LEETCODE.arrays.blindQues;

import LEETCODE.arrays.ArrayInput;

public class Leetcode_1920_Buildarrayfrompermutation {
    public static int[] functionnntocalculatearray(int nums[]){
        // brute force 
        int n = nums.length;
        int[] temp = new int[n];
        int x = 0;
        for(int i = 0; i < n; i++){
            temp[x++] =  nums[nums[i]];
        }
        return temp;
    }

    // optimal solution 
    public static int[] optimalarrproch(int [] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }
        for(int i = 0; i < n; i++){
            nums[i] = nums[i]/ n;
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[]  = ArrayInput.takeArrayInput();

        int [] result = functionnntocalculatearray(nums); 
                int [] result2 = optimalarrproch(nums);


        for(int i = 0; i < result2.length; i++){
            System.out.print(result[i]);
        }

    }
}