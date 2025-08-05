package Functions.basicques;

import java.util.Scanner;

public class primeinrange {
    public static boolean Prime(int n){
        for(int i =2; i<= Math.sqrt(n);i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void PrimeInRange(int n){
        for(int i = 2; i<= n ; i++){
            if(Prime(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println(" ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        int n = sc.nextInt();

        PrimeInRange(n);
    }
}
