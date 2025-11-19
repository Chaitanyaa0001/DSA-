package arrays;

public class maxsubarraysum {

    public static int maxsubarray(int [] numbers){
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0; i <= numbers.length-1; i++){
            int start = i;
            for(int j = i; j <= numbers.length-1; j++){
                int sum = 0;
                int end = j;
                for(int k = start ; k <= end ; k++){
                    sum = sum + numbers[k];
                }
                if(sum > maxsum){
                   maxsum = sum;
                }
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {

        int numbers [] = {1,2,3,4,5};
       int result =  maxsubarray(numbers);
       System.out.println(result);
        
    }
}
