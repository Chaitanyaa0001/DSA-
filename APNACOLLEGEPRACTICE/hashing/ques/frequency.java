// given an n number of elements and quesreis of array . for every queyr find frequency of elemet in an array 

package hashing.ques;

import java.util.HashMap;

public class frequency {
    public static void findfrequency(int nums[], int queries[]){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])){
                int temp = hm.get(nums[i]);
                hm.put(nums[i], temp++);
            }else{
                hm.put(nums[i], 1);
            };
        }
    }


    public static void main(String[] args) {
        int nums []  = {2,6,3,8,2,8,2,3,8,10,6};
        int queries [] = {2,8,3,5};
        
    }
}
