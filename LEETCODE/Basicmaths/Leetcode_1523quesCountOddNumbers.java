package LEETCODE.Basicmaths;

// 1523. Count Odd Numbers in an Interval Range
// Hint
// Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

// Example 1:
// Input: low = 3, high = 7
// Output: 3
// Explanation: The odd numbers between 3 and 7 are [3,5,7].
// Example 2:
// Input: low = 8, high = 10
// Output: 1
// Explanation: The odd numbers between 8 and 10 are [9].
// Constraints:
// 0 <= low <= high <= 10^9
import java.util.Scanner;


public class Leetcode_1523quesCountOddNumbers {
    public static  int countNumber(int low, int high){
        int check = (high - low) / 2 + ((high % 2 !=0 || low % 2!= 0)?1:0);
        return  check;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println(countNumber(low, high));
    }
}
