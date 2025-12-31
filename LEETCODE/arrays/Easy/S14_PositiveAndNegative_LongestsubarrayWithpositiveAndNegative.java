import java.util.HashMap;
import java.util.Scanner;

import LEETCODE.arrays.ArrayInput;

public class S14_PositiveAndNegative_LongestsubarrayWithpositiveAndNegative {

    public static int btuteforce(int[] nums, int k){
        int n = nums.length;
        int maxlen = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum == k){
                    int length = j - i +1;
                    maxlen =  Math.max(maxlen,length);
                }
                
            }
        }

        return maxlen;
    }

    public static int optimal(int[] nums, int k ){
        int n = nums.length;
        HashMap <Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(map.containsKey(sum -k)){
                int j = map.get(sum-k);
                int length = i - j +1;
                maxlen = Math.max(maxlen, length);
            }
        }
        return maxlen;
    }


    public static void main(String[] args) {
        int [] nums = ArrayInput.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int brute =  btuteforce(nums, k);
        System.out.println(brute);
    }
}