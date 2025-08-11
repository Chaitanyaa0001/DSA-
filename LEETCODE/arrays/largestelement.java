package LEETCODE.arrays;

public class largestelement {
    public static int findlargest(int [] numbers){
        
        int largest = numbers[0];
        for(int i = 0; i< numbers.length;i++){
            if(numbers[i] >largest){
                largest = numbers[i];
            }
        }
        return largest;
    };
    public static void main(String[] args) {
        int numbers [] = {3,2,1,6,2};
       int result =  findlargest(numbers);
       System.out.println("largest element :" + result);
    }
    
}
