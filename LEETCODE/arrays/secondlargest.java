package LEETCODE.arrays;

import arrays.maxsubarraysum;

public class secondlargest {

    public static int secondlargest(int [] numbers){
        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;
        for(int i = 0; i< numbers.length; i++){
            if(numbers[i]> largest){
                secondlargest = largest;
                largest = numbers[i];
            }else if( numbers[i] > secondlargest && numbers[i] !=  largest){
                secondlargest =  numbers[i];
            }
        }
        return secondlargest;
    }
    public static void main(String[] args) {
        int numbers [] = {8,8,8,7,6,5};
         int result =secondlargest(numbers);
         System.out.println(result);
    }
    
}
