package arrays;

public class prefixsum {

    // to use prifix sum we need to follow some steps and to make a prefix array and then calculate this 
    public static void checkprefixsum(int[] numbers) {
        int maxsum = Integer.MIN_VALUE;
        int prefix [] = new int[numbers.length];
        prefix[0] = numbers[0];
        for(int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i-1] + numbers[i];
        }

        for(int i = 0; i< numbers.length;i++){
            int start = i;
            for(int j = 0; j< numbers.length; j++){
                int end = j;
                int currentsum = 0;
                currentsum = start== 0? prefix[end] :prefix[end] - prefix[start-1];
                if(currentsum > maxsum){
                    maxsum = currentsum;
                }
                
            }
            
        }
        System.out.println("max sum :"+ maxsum);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        checkprefixsum(numbers);
    }
}
 