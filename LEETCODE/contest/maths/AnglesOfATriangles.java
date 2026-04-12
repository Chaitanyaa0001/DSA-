package LEETCODE.contest.maths;

import java.util.Arrays;

public class AnglesOfATriangles {
    
    private static  double[] internalAngles(int[] sides) {
        int[] norqavelid =  sides;
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        if(a+b<=c){
            return new  double[0];
        }
        double A = Math.toDegrees(Math.acos((b*b + c*c - a*a) / 2.0 * b * c ));
        double B = Math.toDegrees(Math.acos((a*a + c*c - b*b) / 2.0 * a * c ));
        double C = Math.toDegrees(Math.acos((a*a + b*b - c*c) / 2.0 * a * b ));
        double[] ans = {A,B,C};
        Arrays.sort(ans);
        return ans;
    }
    // cosine rule to find triangle 
    // a sqaure + b square - c square / a * side *side 
    public static void main(String[] args) {
        int [] sides = {3,4,5};
        internalAngles(null);
    }
}