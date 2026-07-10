import LEETCODE.arrays.ArrayInput;

public class S10_Leetcode_268findmissingnumberinrange {
    private static int functionnumber(int nums[]){
        int n = nums.length;
        int actualsum = n * (n+1) /2;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        };

        return actualsum - sum;
    }

    private static int withzor(int nums[]){
        int result = 0; 

        for(int num : nums){
            result ^= num;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int nums[] = ArrayInput.takeArrayInput();
        functionnumber(nums);
        withzor(nums);

    }
}
