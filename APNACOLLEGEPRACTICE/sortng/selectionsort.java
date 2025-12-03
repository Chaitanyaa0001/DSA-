package sortng;

public class selectionsort {
    public static void selectionSort( int  [] arr ){
        int n = arr.length;
        for(int i = 0; i < n; i++ ){
            int smallest = i;
            for(int j = i; j < n;j++){
                if(arr[j] < arr[smallest]){
                    smallest = j; 
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
               
        }
    }

    // sorted array 
    public static void sortedarrprint(int arr[]){
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        int arr [] = {5,4,7,8,4,5,2,1};
        System.out.println("selection sort algo");
        selectionSort(arr);
        // printing 
        sortedarrprint(arr);

    }
}