package sortng;

public class insertionsort {
    public static void insertionSort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            // to find and to temporary store the current elemnt so that it can be inserted 
            int currentelement = arr[i]; 
            // this is the previous elemnt thorugh which we can do backtract to comare my elemnets 
            int previous = i-1;
            // to find the element 
            // loop when our previos elemnt is greater than 0 and greater than the current element 
            while (previous >= 0 && arr[previous] > currentelement) {
                // then find the elemnt form backtrack 
                arr[previous +1] = arr[previous];
                previous --;
            }
            // to insertion 
            arr[previous + 1] = currentelement;
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

        insertionSort(arr);
        printInsertionSort(arr);
    }
}
