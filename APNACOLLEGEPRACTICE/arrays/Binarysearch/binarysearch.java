package arrays.Binarysearch;

import java.util.Scanner;

public class binarysearch {

    public static int Binarysearch(int numbers [], int Key){

        int start = 0;
        int end = numbers.length - 1;
        int mid = start + (end-start)/2;
        for(int i = 0; i <= numbers.length-1; i++){
            if(Key == numbers[i]){
                return i;
            }else if(Key > mid ){
                start = mid +1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
        public static void main(String[] args) {

        int numbers [] = {2,3,4,5,7,8,9};
        Scanner sc = new Scanner(System.in);        
        int Key = sc.nextInt();


        int result = Binarysearch(numbers, Key);

         System.out.println("index for key " + result);
        
    }
    
}
