import LEETCODE.arrays.ArrayInput;

public class S10_Leetcode_268findmissingnumberinrange {
    public static int functionnumber(int nums[]){
        int n = nums.length;
        int actualsum = n * (n+1) /2;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        };

        return actualsum - sum;
    }
    public static void main(String[] args) {
        int nums[] = ArrayInput.takeArrayInput();
        functionnumber(nums);

    }
}
