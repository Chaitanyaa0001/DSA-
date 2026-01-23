package LEETCODE.BinarySearch.blind;

import java.util.Scanner;

public class Leetcode_278_FirstBadVersion {

   public static boolean isBadVersion(int version){

        if(version == 4 ){
            return true;
        }else{
            return false;
        }
   }
    public static  int firstBadVersion(int n) {
        int start = 0;
        int end =  n;
        int ans  = 0;
        while(end >= start){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid) ){
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }
        return start ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(firstBadVersion(n));
    }
}