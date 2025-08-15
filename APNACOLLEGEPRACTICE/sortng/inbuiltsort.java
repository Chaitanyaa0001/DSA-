package sortng;

import java.util.Arrays;
import java.util.Collections;

public class inbuiltsort {
   
    public static void sortedarr(Integer [] arr){
        for(int i =0; i< arr.length; i++ ){
            System.out.print(    arr[i]  );
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer arr [] = {4,2,6,1,5,3};

        // in ascending order 
        Arrays.sort(arr);
        // in descending order 
        // in this this can only be applied on the objects Integer not int primitivve datatype
        Arrays.sort(arr,Collections.reverseOrder());
        sortedarr(arr);

        
       
    }
}
