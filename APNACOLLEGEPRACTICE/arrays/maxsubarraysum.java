package arrays;

public class maxsubarraysum {

    public static void maxsubarray(int [] numbers){
        int max = Integer.MIN_VALUE;
        int currentsum = 0;
        for(int i = 0;i< numbers.length;i++){
            int start = i;
            for(int j = 1;j< numbers.length;j++){
                int end = j;
                currentsum =0;
                for(int k = i;k <= j ;k++){
                   currentsum += numbers[k];
                }
                if(currentsum > max){
                    max  = currentsum;
                }
            }
            
        }
        System.out.println(max);

    }

    public static void main(String[] args) {

        int numbers [] = {1,2,3,4,5};
        maxsubarray(numbers);
        
    }
}
