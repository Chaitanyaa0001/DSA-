package LEETCODE.arrays.Hard;
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.
// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
// Example 2:
// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
// Example 3:
// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.
// Constraints:
// 3 <= nums.length <= 3000
// -105 <= nums[i] <= 105
import java.util.*;

import LEETCODE.arrays.ArrayInput;

public class S2_Leetcode15_Threesum {

    public static List<List<Integer>> bruteforce(int[] nums){
        HashSet<List<Integer>> set = new HashSet<>();

        int n = nums.length;
        for(int i = 0 ; i <  n ; i++){
            for(int j  = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if(nums[i]+ nums[j]+ nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> betterapproch(int[] nums){
        int n = nums.length;
        HashSet <List<Integer>> ans = new HashSet<>();
        for(int i = 0; i < n; i++){
            HashSet<Integer> temp = new HashSet<>();
            for(int j = i+1; j < n; j++){
                int third = -(nums[i] + nums[j]);
                if(temp.contains(third)){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(list);
                    ans.add(list);
                }

                temp.add(nums[j]);
            }
        }

        return new ArrayList<>(ans);
    }

    public static List<List<Integer>> optimalpproch(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while ( j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                }else if( sum < 0){
                    j++;
                }else{
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    set.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
            }

        }
        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
      //  Input: nums = [-1,0,1,2,-1,-4]
        int[] nums = ArrayInput.takeArrayInput();
        // System.out.println(bruteforce(nums));
        // System.out.println(betterapproch(nums));
        System.out.println(optimalpproch(nums));

    }
}