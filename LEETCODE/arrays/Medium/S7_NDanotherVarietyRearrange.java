    package LEETCODE.arrays.Medium;

    import java.util.*;

import LEETCODE.arrays.ArrayInput;

    public class S7_NDanotherVarietyRearrange {
        // int this we dont have given the  array will be of equal index or number of eqpal 
        // elemtes i.e elemts can be uneuqal so u have to add at last if any eemh
        // t left in specific order 
        private static int[] whenposIsNotEqualtoNegative(int[] nums){
            int ans[] =  new int[nums.length];
            List<Integer> pos = new ArrayList<>();
            List<Integer> neg = new ArrayList<>();
            int n = nums.length;
            for(int i = 0; i < n; i++){
                if(nums[i] > 0){
                    pos.add(nums[i]);
                }else{
                    neg.add(nums[i]);
                }
            }
            
            for(int i = 0; i < Math.min(pos.size(),neg.size()); i++){
                ans[2 * i]  = pos.get(i);
                ans[2 * i + 1] = neg.get(i);
            }
            int index = 2 *  Math.min(pos.size(), neg.size());
            if(pos.size() > neg.size()){
                for(int i = Math.min(pos.size(),neg.size()); i < pos.size(); i++){
                    ans[index++] = pos.get(i);
                }
            }else{
                for(int i = Math.min(pos.size(),neg.size()); i < neg.size(); i++){
                    ans[index++] = neg.get(i);
                }
            }
            
            return ans;

        }
        public class InnerS7_anotherVarietyRearrange {

            public static void main(String[] args) {
                int [] nums = ArrayInput.takeArrayInput();
                whenposIsNotEqualtoNegative(nums);

            }
            
        }   
    }
