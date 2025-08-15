package sortng;

public class countsort {
   public static void count(int nums []){
        // find range  
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            largest = Math.max(largest, nums[i]);
        };
        // count arr 
        int count [] = new int [largest+1];
        for(int i = 0 ; i < nums.length; i++){
            count[nums[i]]++;
        };
        int j = 0;
        for(int i = 0; i < count.length; i++){
            while (count[i] > 0) {
                nums[j] = i;
                j ++;
                count[i] --;
            }
        }
    }
    public static void printval(int nums[]){
        for(int i = 0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr [] = {2,0,2,1,1,0};
        count(arr);
        printval(arr);

    }
}
