package LEETCODE.arrays.Medium;

import LEETCODE.arrays.ArrayInput;

import java.util.Arrays;
import java.util.HashSet;

public class S9_longestConsecutiveInanArray {
    private static boolean  linearsearch(int a[], int key){
        for(int i = 0; i < a.length; i++){
            if(a[i] == key){
                return true;
            }
        }
        return false;
    }
    private static int  brutforce(int a[]){
        int n =a.length;
        int longest  = 1;
        // har ek emeent ke liye check karo ki kya hai 
        for(int i = 0 ; i < n; i++){
            int num = a[i];
            int count = 1;
            while (linearsearch(a,num + 1)) {
                num = num + 1;
                count++;
            }
            longest = Math.max(count,longest);
        }
        return longest;
    }

    private static int  betterappproch(int[] nums){
        Arrays.sort(nums);
        int longest =1;
        int count = 0;
        int smaller = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]-1 == smaller){
                count++;
                smaller = nums[i];
            }else if ( nums[i] != smaller){
                count = 1;
                smaller = nums[i]; 
            }
            longest = Math.max(longest, count);
        }
        return 0; 
    }
    private static int  optimalapproch(int a[]){
        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int num : a){
            // store all ements in hashset 
            set.add(num);
        }
        for(int i : set){
            if(!set.contains(i-1)){
                // agar mera starting point hai ye 
                int count = 1;
                int element = i;
                // jab tak mera set mei consecutive element exist krta hai tab tak count ki value ++ 
                while (set.contains(element +1)){
                    count++;
                    element = element+1;
                }
                // upate longest 
                
                longest = Math.max(count, longest);
            }
        }
        return longest;
        // now check for each elent if previos exist then move to nexxt 
        //  if previos does not exist then its my starting point now chekc for every next and increase the coundter 

    }

    public static void main(String[] args) {
        int [] nums = ArrayInput.takeArrayInput();
        brutforce(nums);
        betterappproch(nums);
        optimalapproch(nums);
    }
}
