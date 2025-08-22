package A2Darrays;

// Question 2 :Print out the sum of the numbers inthe second row of the “nums” array.Example :Input - int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };Output - 18
public class printsumofrow {
    public static int printSumOfSecondRow(int nums[][]){
        int sum = 0;
        int row = 1;
        for(int i = 0; i < nums[row].length ; i++ ){
            sum = sum + nums[row][i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
        int result = printSumOfSecondRow(nums);
        System.out.println(result);
    }
}
