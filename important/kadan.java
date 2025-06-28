package important;

public class kadan {

    public static void kadanalosum(int numbers []){
        int cs = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<numbers.length;i++){
                cs+= numbers[i];
            if(cs < 0){
                cs = 0;
            }
            max =Math.max(cs, max);

        }
        System.out.println("kadan also sub arrayu sum " + max);
    }

    public static void main(String[] args) {
        int numbers [] ={-2,-3,4,-1,-2,1,5,-3};
        kadanalosum(numbers);

        
        
    }
}