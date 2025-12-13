import LEETCODE.arrays.ArrayInput;

public class S5_Leftroatearray {
    public static void leftrotatebyone(int[] arr){
        int n = arr.length;
        int temp  = arr[0];
        for(int i = 1; i < n; i++ ){
            arr[i-1] = arr[i]; 
        }
        arr[n-1] = temp;

    }
    
    
    public static void main(String[] args) {
        int[] arr = ArrayInput.takeArrayInput();
        leftrotatebyone(arr);

        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}
