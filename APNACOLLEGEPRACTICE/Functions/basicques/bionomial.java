package Functions.basicques;

import java.util.Scanner;

class Binomial {

    public static long binomialCoefficient(int n, int r) {
        if (r > n - r) {
            r = n - r; // Since C(n, r) == C(n, n - r)
        }

        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        System.out.print("Enter the value of r: ");
        int r = sc.nextInt();

        if (r < 0 || r > n) {
            System.out.println("Invalid values! r should be between 0 and n");
            return;
        }

        long result = binomialCoefficient(n, r);
        System.out.println("Binomial Coefficient C(" + n + "," + r + ") = " + result);
    }
}
