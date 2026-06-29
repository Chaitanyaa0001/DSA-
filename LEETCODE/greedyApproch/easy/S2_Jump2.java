package LEETCODE.greedyApproch.easy;

public class S2_Jump2 {
    private static int minjumps(int a[]){
        int l = 0;
        int r = 0;
        int n = a.length;
        int jump =0;
        while (r < n-1) {
            
            int far = 0;
            for(int i = 0; i <= r; i++){
                far = Math.max(far, i+a[i]);
            }
            l = r+1;
            r =far;
            jump++;
        }
        return jump;
    }
    public static void main(String[] args) {
        int a[] = {2,3,1,4,1,1,1,2};
        minjumps(a);

    }
}
