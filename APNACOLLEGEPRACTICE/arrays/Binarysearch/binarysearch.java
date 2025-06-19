package arrays.Binarysearch;

public class binarysearch {

    public static int Binarysearch(int numbers [], int n){

        int start = 0;
        int end = numbers.length -1;
        

        while (start<=end)  {
            int mid = (start +end ) / 2;
            if(numbers[mid] == n){
                return mid;
            }
            else if(numbers[mid] < n){
                start = mid + 1;
            }else {
                                end = mid - 1;

                
            }
        }
        return -1;

    }
    public static void main(String[] args) {

        int numbers [] = {2,3,4,5,7,8,9};
        int n = 2;


         int result = Binarysearch(numbers, n);

         System.out.println("index for key " + result);
        
    }
    
}
