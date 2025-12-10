
public class leftroatearray {
    public static void leftRotate(int nums[]){
        int temp = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++ ){
            nums[i-1] = nums[i];
        }
        nums[n-1] = temp;
        for(int i = 0; i< n; i++){
            System.out.print(nums[i] + "");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        leftRotate(nums);
    }
}
