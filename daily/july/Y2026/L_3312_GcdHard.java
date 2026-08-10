package daily.july.Y2026;

import java.util.Arrays;

public class L_3312_GcdHard {

    private static int gcd(int a, int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public static  int[] brute(int[] nums, long[] queries) {
        int n = nums.length;
        int m = n * (n - 1) / 2; // total array size for each pair 
        int[] ans = new int[queries.length];
        int gcdPairs[] = new int[m];
        int x = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int g =  gcd(nums[i],nums[j]);
                gcdPairs[x++] = g;
            }
        }
        for(int i = 0; i < queries.length; i++){
            ans[i] = gcdPairs[(int)queries[i]];
        }

        return ans;
    }
    
    private static int[] optimal(int nums[], long q[]){
        // merko isme constrains 10 *5 given h or har pair ka check krnne mei n square ayaga to we can do that  
        int ans[] = new int[nums.length];
        return ans;


        
    }
    public static void main(String[] args) {
        int nums[] = {2,3,4};
        long q[] = {0,2,2};
        brute(nums, q);
        optimal(nums, q);
        
    }
}
