package LEETCODE.recursionBasic;

public class ReverseArray {
    public static void  ReverseUsingRecurrsion(int[] arr, int left, int right){
        
        if(left >= right){
            return;
        }
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        ReverseUsingRecurrsion(arr, left+1, right-1);

    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        ReverseUsingRecurrsion(arr, 0, arr.length-1);

        for(int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }   
}
