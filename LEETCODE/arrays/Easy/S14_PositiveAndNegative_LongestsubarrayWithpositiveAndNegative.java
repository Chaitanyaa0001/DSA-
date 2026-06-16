import java.util.HashMap;
import java.util.Scanner;

import LEETCODE.arrays.ArrayInput;

public class S14_PositiveAndNegative_LongestsubarrayWithpositiveAndNegative {

    private static int btuteforce(int[] nums, int k){
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

    // it is optimal for when it incudes negative number 
    private static int optimal(int[] nums, int k ){
       int n = nums.length;
       HashMap <Integer,Integer> map = new HashMap<>();
       int sum = 0;
       int maxlen = 0;
       for(int i = 0; i < n; i++){
           sum += nums[i];
           if( sum == k ){
              maxlen = i + 1;

           }
           if(map.containsKey(sum -k)){
               int j = map.get(sum-k); 
               int length = i - j +1;
               maxlen = Math.max(maxlen, length);
           }
        //    agar mera map mei ek sum already hai to agar vo duabara ata hai t vo uski value update kr deta hai 
        //    to humko sirf tabhi add krna hai jab already sum nhi ho 
           if (!map.containsKey(sum)) {
                map.put(sum, i);
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
        optimal(nums, k);
        sc.close();
    }
}