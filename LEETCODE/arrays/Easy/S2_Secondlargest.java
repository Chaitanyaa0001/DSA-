import LEETCODE.arrays.ArrayInput;

public class S2_Secondlargest {
    private static  int secondlargest(int[] numbers){
        int n = numbers.length;
        int secondlargest = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int  i = 0; i < n; i++){
            if(numbers[i] > largest){
                secondlargest = largest;
                largest = numbers[i];
            }else if(numbers[i] > secondlargest && numbers[i] != largest){
                secondlargest = numbers[i];
            }
        }
        return secondlargest;
    }
    private static void main(String[] args) {
        int [] numbers = ArrayInput.takeArrayInput();
        int result =secondlargest(numbers);
         System.out.println(result);
    }
    
}
