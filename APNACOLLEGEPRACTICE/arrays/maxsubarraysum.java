package arrays;

public class maxsubarraysum {

    public static void maxsubarray(int [] numbers){
        
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0; i< numbers.length; i++){
            int start = i;
            for(int j = i + 1; j < numbers.length; j++){
                int  end = j;
                int current = 0;
                for(int k = start; k <= end; k++){
                    current += numbers[k];
                };
                if(current > maxsum){
                    maxsum =current;
                }
            }
        }
        System.out.println("the max sum of the array :" + maxsum);
    }

    public static void main(String[] args) {

        int numbers [] = {1,2,3,4,5};
        maxsubarray(numbers);
        
    }
}
