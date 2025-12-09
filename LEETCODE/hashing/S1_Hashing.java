    package LEETCODE.hashing;

    import java.util.*;

    public class S1_Hashing {

        public static void calculateFrequency(int[] arr, int q){
            int count = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == q){
                    count++;
                }
            }
            System.out.println(count);
        }
        

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int[] arr = new int[n];
            // Read array (no messages)
            for(int i = 0; i < arr.length; i++){
                arr[i] = sc.nextInt();
            }

            // pre computation 
            int[] hasharr = new int[1000000000];
            for(int i = 0; i <arr.length; i++){
                hasharr[arr[i]]++;
            }
            int q = sc.nextInt();
            for(int i = 0; i < q; i++){
                int x = sc.nextInt();

                System.out.println( hasharr[x]);
            }
        }
    }
