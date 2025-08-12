package important;

public class kadan {

    public static void kadanalosum(int numbers []){
        int cs = 0 ;
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++){
            cs += numbers[i];
            if(cs < 0)
            cs = 0;
            maxsum =  Math.max(maxsum, cs);
        }
        System.out.println(maxsum);
    }


    
    public static void main(String[] args) {
        int numbers [] ={-2,-3,4,-1,-2,1,5,-3};
        kadanalosum(numbers);

        
        
    }
}