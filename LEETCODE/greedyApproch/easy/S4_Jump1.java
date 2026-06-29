package LEETCODE.greedyApproch.easy;

public class S4_Jump1 {
    private static boolean jump(int a[]){
        int maxindex = 0;
        int n = a.length;
        for(int i = 0; i < n; i++){
            if(i > maxindex){
                return false;
            };
            maxindex = Math.max(maxindex, i + a[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int [] a = {3,2,13,2,1,3};
        jump(a);
    }
}
