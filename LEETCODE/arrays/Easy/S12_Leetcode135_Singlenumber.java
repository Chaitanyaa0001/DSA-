import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

import LEETCODE.arrays.ArrayInput;

public class S12_Leetcode135_Singlenumber {
    // bruteforce 
    public static int bruteforce(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(nums[j] == nums[j]){
                    count++;
                }
            }
            if(count == 1){
                return nums[i];
            }
        }
        return -1;
    }
    // better by hashmap or hashing 
    public static int better(int [] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int optimal(int[] nums){
        int result = 0;
        for(int num : nums){
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = ArrayInput.takeArrayInput();
        bruteforce(nums);
    }
}