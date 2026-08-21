import java.util.*;

public class The_67_intProblemTill7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int[] arr = new int[7];
            int sum = 0;
            
            for(int i = 0; i < 7; i++){
                arr[i] = sc.nextInt();
            }

            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 7; i++){
                max = Math.max(arr[i], max);
            }

            boolean checkmax = false;
            int ans = 0;
            for(int i = 0; i < 7; i++) {
                if(arr[i] == max && !checkmax){
                    ans += arr[i];
                    checkmax = true;
                }else{
                    ans  = ans + (-arr[i]);
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}