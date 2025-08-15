package sortng;

public class selectionsort {
    public static void selectionsort( int  [] arr ){
        for(int i = 0;i < arr.length-1;i++){
            int minpos = i;
            for(int j = i+1; j< arr.length;j++){
                if(arr[minpos] >arr[j]){
                    minpos = j;
                }
            }
            // swapping outside the loop 
            int temp = arr[minpos];
            arr[minpos] = arr[i];
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
        selectionsort(arr);
        // printing 
        sortedarrprint(arr);

    }
}