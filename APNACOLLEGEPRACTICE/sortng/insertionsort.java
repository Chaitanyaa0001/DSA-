package sortng;

public class insertionsort {

    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i< n; i++){
            while (i > 0 && arr[i-1] > arr[i] ) {
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                    i--;
            }
        }
    }


    public static void printInsertionSort(int arr[]){
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
