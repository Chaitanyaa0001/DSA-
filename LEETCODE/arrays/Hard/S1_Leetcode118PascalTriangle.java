package LEETCODE.arrays.Hard;

public class S1_Leetcode118PascalTriangle {
    private static int factorial(int n){
        int product = 1;
        for(int i = n; i >= 1; i--){
            product *= i;
        }
        return product;
    }
    private static int type1QuestionRandC(int row, int col){
        int n = factorial(row - 1);
        int r = factorial(col - 1);
        int nr = factorial(row - col);
        return n / (r * nr);
        // -----------------------------
        // now better approch we can solve as uk when ever we find same factoral like 5 and 5 we cancel we dont solve till en
         
    }
    public static void main(String[] args) {
    
    }
}