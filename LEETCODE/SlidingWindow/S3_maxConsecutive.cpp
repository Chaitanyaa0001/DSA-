package LEETCODE.SlidingWindow;

public class S3_maxConsecutive {
    private  static int bruteforce(int[] a, int k){
        int n = a.length; int maxlen = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = i; j < n; j++){
                if(a[j] == 0){
                    count++;
                }
                if(count > k){
                    break;
                }
                if(count <= k){
                    int len = j - i + 1;
                    maxlen = Math.max(maxlen,len);
                }
            }
        }
        return maxlen;
    }
    private static int betterApproch(int a[], int k){
        int n = a.length;
        int count = 0;
        int l = 0,r = 0;
        int len = 0;
        int maxlen = 0;
        while (r < n) {
            if(a[r] == 0){
                count++;
            }
            while (count > k) {
                if(a[l] == 0){
                    count--;
                }
                l++;
            }
            if(count <= k){
                len =  r - l + 1;
                maxlen = Math.max(len,maxlen);
            }
        }
        return maxlen;
    }

    private static int optimal(int a [], int k){
        int n = a.length;
        int r = 0 , l = 0;
        int len = 0; int maxlen = 0;
        int count = 0;
        while (r < n) {
            if(a[r] == 0){
                count++;
            }
            if(count > k){
                if(a[l] == 0){
                    count--;
                }
                l++;
            }
            if(count <= k){
                len = r-l+1;
                maxlen = Math.max(maxlen, len);
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int []  a = {1,1,1,0,0,0,1,1,1,1,0};
        bruteforce(a, 0);
        betterApproch(a, 0);
        optimal(a, 0);
    }
}