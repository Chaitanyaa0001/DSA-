import LEETCODE.arrays.ArrayInput;

public class S2_Secondlargest {
    private static  int secondlargest(int[] numbers){
        int n = numbers.length;
        int secondlargest = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int  i = 0; i < n; i++){ 
            // check kro agar mera current elemnt bada hai mera largest se to largest ko update krne se pehla largest ki value second  largest mei dedo
            if(numbers[i] > largest){
                secondlargest = largest;
                largest = numbers[i];

            }else if(numbers[i] > secondlargest && numbers[i] != largest){
                // ab agar meri current vi value largest to hai nhi  to matlab vo choti hai usse  ab check karo agar current ki value meri secordlargest se badi hai or largest  mei jo store tha vo vlaue or meri current same nhi hona chaoye for duplicates 
                secondlargest = numbers[i];
            }
        }
        return secondlargest;
    }
    public static void main(String[] args) {
        int [] numbers = ArrayInput.takeArrayInput();
        int result =secondlargest(numbers);
         System.out.println(result);
    }
    
}
