package sortng;

public class quicksort {
    // public static int partitionlast(int arr[],int start,int end){
    //     int index = start-1;
    //     int pivit = arr[end];
    //     for(int j = start; j< end;j++){
    //         if(arr[j] < pivit){
    //             index++;
    //             // swaping 
    //             int temp = arr[j];
    //             arr[j] = arr[index];
    //             arr[index] = temp;
    //         }
    //     }
    //      // placement of pivit at correct position
    //         int temp = arr[index+1];
    //         arr[index+1] = arr[end];
    //         arr[end] = temp; 
    //     return index+1;


    
    // }
    
    // public static void QuickSortLast(int arr[], int start, int end){
    //     if(start < end){
    //         int pivit = partition(arr, start, end);
    //         QuickSort(arr, start, pivit-1);
    //         QuickSort(arr, pivit+1,end );
    //     }
    // }
    public static int partitionfirst(int arr[],int start,int end){
        int pivit = arr[start];
        int index = start+1;
        for(int j = start+1; j<= end;j++){
            if(arr[j] < pivit){
                // swaping 
                int temp = arr[j];
                arr[j] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
         // placement of pivit at correct position
            int temp = arr[index-1];
            arr[index-1] = arr[start];
            arr[start] = temp; 
        return index-1;
    }
    public static void QuickSortFirst(int arr[], int start, int end){
        if(start < end){
            int pivit = partitionfirst(arr, start, end);
            QuickSortFirst(arr, start, pivit-1);
            QuickSortFirst(arr, pivit+1, end);
        }
    }
    
    public static void main(String[] args) {
        int arr [] = {3,4,1,6,4,2,7,9,2,3,};
        int n = arr.length;
        // QuickSortLast(arr, 0, n-1);
        QuickSortFirst(arr, 0, n-1);
        for(int i = 0;  i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
