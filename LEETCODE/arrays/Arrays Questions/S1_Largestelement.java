
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

       int result =  findlargest(arr);
       System.out.println(result);
    }
    
}
