package LEETCODE.hashing;

import java.util.Scanner;

public class S2_HashingChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        // precomputation 
        int[] hashArr = new int[26];

        for(int i = 0; i < str.length(); i++){
            hashArr[str.charAt(i)- 'a']++;
        }

        int q = sc.nextInt();
               for(int i = 0; i < q; i++){
            char x = sc.next().charAt(0);  
            System.out.println(hashArr[x - 'a']);
        }

        sc.close();


    }
}
