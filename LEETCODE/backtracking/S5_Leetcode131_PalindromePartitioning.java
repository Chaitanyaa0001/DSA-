package LEETCODE.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S5_Leetcode131_PalindromePartitioning {
     public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path  =  new ArrayList<>();
        int n = s.length();
        backtrack(s,0,n,path,ans);
        return  ans;
    }

    private static  void backtrack(String x, int index, int n, List<String> path ,List<List<String>> res){
        if( n == index){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i = index; i < n; i++){
            if(isPalindrome(x,index,i)){
               path.add(x.substring(index, i+1));
               backtrack(x,i+1,n,path,res);
               path.remove(path.size() -1);
            }
        }
    }

    private static boolean isPalindrome(String x, int start, int end){
        while(start <= end){
            if(x.charAt(start) != x.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc   = new Scanner(System.in);
        String s = sc.nextLine();
        partition(s);
    }
}
