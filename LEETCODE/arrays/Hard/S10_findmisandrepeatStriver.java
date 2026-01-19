package LEETCODE.arrays.Hard;

import LEETCODE.arrays.ArrayInput;

public class S10_findmisandrepeatStriver {

    public static int[] bruteforce(int nums[]){
        int n = nums.length;
        int missing = -1;
        int repating = -1;

        for(int i = 1; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(nums[j] == i){
                    count++;
                }
            }
            
            if (count == 2){
                repating = i;
            }
            if(count == 0){
                missing  = i;
            }

            if(repating != -1 || missing != -1){
                break;
            }
        }
         return new int[]{repating,missing};
    }


    public static int [] betterapproch(int[] nums){
        int n = nums.length;
        int hash[] = new int[n];
        int missing = -1;
        int repeating = -1;
        for(int i = 0; i < nums.length; i++){
            hash[nums[i]]++;
        }
        for(int i = 1; i < hash.length; i++){
            if(hash[i] == 2){
                repeating = i;
            }
            if(hash[i] == 0){
                missing = i;
            }

            if(repeating != -1 || missing != -1){
                break;
            }
        }

        return new int[]{repeating,missing};
        
    }

    public static void main(String[] args) {
        int[] nums = ArrayInput.takeArrayInput();

    }
}
