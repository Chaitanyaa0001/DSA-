package LEETCODE.sortng;

public class insertionsort {

    private static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i< n; i++){
            int j = i;
            while (j > 0 && arr[j-1] > arr[j] ) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    j--;
            }
        }
    }


    private static void printInsertionSort(int arr[]){
        for(int i = 0; i< arr.length; i++){
            System.out.print( arr[i] +" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr [] = {4,2,6,1,5,3};
        // {2,4,6,1,5,3} i=1; prev = 0
        // {2,4,6,1,5,3 } prev =1 i = 2
        // {2,4,1,6,5,3 } prev = 2 i = 3
        insertionSort(arr);

        printInsertionSort(arr);
    }
}
