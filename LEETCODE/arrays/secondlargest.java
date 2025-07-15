package LEETCODE.arrays;

import arrays.maxsubarraysum;

public class secondlargest {

    public static int secondlargest(int [] numbers){
        int secondlargest = 0;
        int findlargest = numbers[0];

            for(int i = 0;i <= numbers.length; i++){
                findlargest = numbers[i];
                for(int j = 0; j<= i;j++){
                    secondlargest = numbers[j];
            
                if( (findlargest) == secondlargest){
                    secondlargest = numbers[j];
                }
            }
        }
        return secondlargest;
    }
    public static void main(String[] args) {
        int numbers [] = {8,8,7,6,5};
         int result =secondlargest(numbers);
         System.out.println(result);

    }
    
}
