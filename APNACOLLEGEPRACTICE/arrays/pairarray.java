package arrays;

import java.util.Scanner;

public class pairarray {

    public  static  void checkpair(int [] numbers){
        for(int i = 0; i < numbers.length ; i++){
            int current = numbers[i];
            for(int j = i+1; j < numbers.length; j++){
                System.out.print("(" + current +"," + numbers[j] + ")" );
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int numbers [] = {2,3,4,5,6,7,8,9};

        checkpair(numbers);

    }
    
}
