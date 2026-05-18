package LEETCODE.SlidingWindow;

public class S9_BinaryArray {
    private static int bruteforce(int[] a){
        int maxlen = 0;
        int n  = a.length;
        int count  = 0;
        for(int i = 0 ; i < n; i++){
            int sum = 0;
            for(int j = i ; j < n; j++){
                if(sum <= 2){
                   count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }

    private static int 

    public static void main(String[] args) {
        int[] a = {2,4,5,2,4,6};

    }
}

