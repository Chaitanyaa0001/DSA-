
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

/**
 * The_67_Permutation
 */
public class The_67_Permutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t --> 0) {
            int n = sc.nextInt();

            List<Integer> ans  = new ArrayList<>();
            int i = 1;
            int j = 3 * n;
            for(int k = 0; k < n; k++){
                ans.add(i);
                i++;
                ans.add(j);
                j--;
                ans.add(j);
                j--;
            }
            for(int num : ans){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}