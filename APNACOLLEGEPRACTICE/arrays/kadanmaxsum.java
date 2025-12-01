package arrays;

public class kadanmaxsum {

    public static void maxsumKadan(int[] numbers){
        int currentsum = 0;
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0; i < numbers.length; i++){
            currentsum = currentsum + numbers[i];
            maxsum = Math.max(currentsum, maxsum);
            if(currentsum < 0){
                currentsum = 0;
            }
        }
        System.out.println(maxsum);
    }
    public static void main(String[] args) {
        int[] numbers = {-2, 10, -1, 2};
        maxsumKadan(numbers);
    }
}
