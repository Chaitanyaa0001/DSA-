
import java.util.Scanner;
import LEETCODE.arrays.ArrayInput;
public class S1_Largestelement {

    public static int findlargest(int[] arr){
        int largestValue = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i]> largestValue){
                largestValue = arr[i];
            }
        }
        return largestValue;
    }
    public static void main(String[] args) {
       int [] arr = ArrayInput.takeArrayInput();
       int result =  findlargest(arr);
       System.out.println("Output" + result);
    }
    
}
