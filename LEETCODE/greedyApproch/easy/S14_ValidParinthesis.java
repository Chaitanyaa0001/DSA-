package LEETCODE.greedyApproch.easy;

public class S14_ValidParinthesis {
    private static boolean dfs(String s, int index, int counter, int n, Boolean dp[][]){

        // time : N raise to power 3 due to 3 branches 
        if(counter < 0){
            return false;
        }
        if(counter > n){
            return false;
        }
        if(index == n){
            return counter == 0; // agar counter 0 ho jai to true agar nhi hota to calse 
        }
        

        if(dp[index][counter] != null){
            return dp[index][counter];
        }

        if(s.charAt(index) == '('){
            return dp[index][counter] =  dfs(s, index+1, counter+1, n,dp);

        }else if(s.charAt(index) == ')'){
            return dp[index][counter] =  dfs(s, index+1, counter-1, n,dp);

        }else{
            return dp[index][counter] =
                    dfs(s, index+1, counter+1, n, dp) ||
                    dfs(s, index+1, counter-1, n, dp) ||
                    dfs(s, index+1, counter, n, dp);
        }

    }
    private static boolean recursiveAppproch(String s){
        int index = 0;
        int counter = 0;
        int n = s.length();
        Boolean dp[][] = new Boolean[n+1][n+1];
        return dfs(s,index,counter,n,dp);
    }
    public static void main(String[] args) {
        String s = "((*)";
        recursiveAppproch(s);

    }
}
