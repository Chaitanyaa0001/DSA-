package arrays;

public class subarrays {
    public static void findSubarrays(int numbers[]){
        for(int i = 0; i <= numbers.length-1; i++){
            for(int j = i; j<= numbers.length-1; j++){
                for(int k = i ; k <= j ; k++){
                    System.out.print(numbers[k] + " ");
                }
                System.out.println(" ");
            }
        }
    }
    
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10};
        findSubarrays(numbers);
    }
}
