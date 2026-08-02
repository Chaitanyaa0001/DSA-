package daily.DP;

public class L486_predictWinner {
     private int isCheck(int i, int j, int nums[]){
        if(i > j){
            return 0;
        }

        if(i == j){
            return nums[i];
        }
        // p1 max  and p2 always min 
        int takeI = nums[i] + Math.min( isCheck(i+2, j, nums), isCheck(i+1,j-1,nums) );

        int takeJ = nums[j] + Math.min( isCheck(i+1, j-1, nums), isCheck(i,j-2,nums) );

        return Math.max(takeI, takeJ);
    }
    public boolean predictTheWinner(int[] nums) {
        // nums =[1,5,233,7]
        //  p1 and p2  both take turns , with  player star first .
        //  both player star the game at : 0
        //  har ek banda array ke start ya en se ek utha sakta hai 
        //   array ka size reuce by one 
        //   and player add number in the score game ends when there are no elementts in arrat 
        int n = nums.length;
        int total = 0;
        for(int i = 0; i < n; i++){
            total += nums[i];
        }
        int player1 = isCheck(0, n-1 , nums);

        int player2 = total - player1;

        return player1 >= player2;


    }
    public static void main(String[] args) {
        
    }
    // Optimal game staretergy concept in this we have to make sure my p1 should win 
    // -> so when its our turn take optimal max, 
    // -> when its oppponent turn make sure he must take worst means min or less 
}
