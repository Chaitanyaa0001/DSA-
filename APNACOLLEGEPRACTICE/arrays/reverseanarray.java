package arrays;

public class reverseanarray {
    public static void reversearray(int [] nums){

        int first = 0;
        int last = nums.length -1;
        while (first < last) {
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp; 

            first ++;
            last--;
        }

    }
    public static void main(String[] args) {

        int nums [] ={2,7,8,5,1,7,3};
         reversearray(nums);
         for (int i = 0;i < nums.length ;i++){
            System.out.print(nums[i] + " ");
         }
       

        
    }
    
}
