package sortng;

public class mergesort {
    public static void conquer(int arr[], int start, int mid, int end){
        int ptr1 = start; 
        int ptr2 = mid+1;
        int temp [] = new int [end-start+1];
        int x = 0;
        // sorting 
        while (ptr1 <= mid && ptr2 <= end) {
            // sort 
            if(arr[ptr1] < arr[ptr2]){
                temp[x++] = arr[ptr1++]; 
            }else{
                temp[x++] = arr[ptr2++];
            }
        }
        while (ptr1 <= mid) {
            temp[x++] = arr[ptr1++]; 
        }
        while (ptr2 <= end) {
            temp[x++] = arr[ptr2++];
        }
        // now export elemts form temp to nums array 
        for(int i = 0,j=start; i < temp.length; i++,j++){
            arr[j] = temp[i];
        }
    }   
    public static  void divide(int arr[], int start , int end){
        if(start >= end) return;
        // mid 
        int mid = start + ( end - start)/2;
        // left array 
        divide(arr, start, mid); 
        // right array 
        divide(arr, mid+1, end);
        // merging the array 
       conquer(arr, start, mid, end);
    } 
    public static void main(String[] args) {
        int arr [] = {3,1,2,4,1,5,2,6,4};
        int n = arr.length;
        divide(arr, 0, n-1);

        for(int i = 0; i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    } 
}
