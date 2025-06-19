package arrays.linearsearch;

import java.util.Scanner;

public class largestnumber {

    public static int LargestNumber( int numbers []){
        int a = Integer.MIN_VALUE;
        for (int i = 0;i<numbers.length;i++ ){
            if(numbers[i] > a)
            a = numbers[i];
        }
        return a;

    }


    public static void main(String[] args) {
        int numbers [] = {1,3,5,3,5,7,9,4,2,4,5};

         int result = LargestNumber(numbers);

        System.out.println("the largest number :" + result);
        
    }
    
}
