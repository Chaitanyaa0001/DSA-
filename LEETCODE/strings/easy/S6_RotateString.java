package LEETCODE.strings.easy;

import java.util.Scanner;

public class S6_RotateString {
    public static Boolean rotatestring(String s , String goal){
        if(s.length() != goal.length()){
            return false;
        }
        String ans = s + s;
        return ans.contains(goal);
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String s = sc.nextLine();
        String goal = sc.nextLine();
    }
    

}
