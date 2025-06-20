package arrays;

public class reverseanarray {
    public static void reversearray(int [] nums){
        int start = 0;
        int end = nums.length -1;
        
        while ( start< end ){

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;  


            start ++;
            end --;
        }
        return ;

    }
    public static void main(String[] args) {

        int nums [] ={2,3,4,5,6,7,8};
         reversearray(nums);
         for (int i = 0;i < nums.length ;i++){
            System.out.print(nums[i] + " ");
         }
       

        
    }
    
}
