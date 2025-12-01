package arrays;

public class prefixsum {

    // to use prifix sum we need to follow some steps and to make a prefix array and then calculate this 
    public static void maxsubarrayPrifix(int [] numbers){
        int currentsum = 0;
        int [] prefixsum = new int[numbers.length];
        prefixsum[0] = numbers[0];
        int maxsum = Integer.MIN_VALUE;
        for(int i = 1; i< prefixsum.length; i++){
            prefixsum[i] = prefixsum[i-1] + numbers[i];
        }

        for(int i = 0; i<numbers.length;i++){
            for(int j = i;j < numbers.length;j++){
                currentsum = i == 0 ? prefixsum[j] : prefixsum[j] - prefixsum[i-1];
            }
            if(currentsum > maxsum){
                maxsum = currentsum;
            }
        }
        System.out.println("maxsum:" + maxsum);
    }

    public static void main(String[] args) {
        int[] numbers = {1,-2,6,-1,3};
        
        maxsubarrayPrifix(numbers);
    }
}
 