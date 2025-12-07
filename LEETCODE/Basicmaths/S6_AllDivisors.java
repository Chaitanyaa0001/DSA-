// it is used to fine the all the divisors of a number 


package LEETCODE.Basicmaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// here we can solve it first with iterations with for loop till n 
// then optimse by root n 
public class S6_AllDivisors {

    public static List<Integer> PrintAllTheDevsiors(int n ){
        // array list creation 
        List <Integer> small = new ArrayList<>();
        List <Integer> large = new ArrayList<>();

        for(int i = 1; i <=Math.sqrt(n); i++){
            // adding elemnts in array list 
            if(n % i == 0){
                small.add(i);
                // check condition if factor like 36 , 18, 12, 9 should not be equal to my i facor as if it will be equal it will print twice 6 
            if (i != n / i) {
                large.add(n / i); 
            }
            } 
        }
        // sorting array list 
        Collections.reverse(large);
        // merging both 
        small.addAll(large);
        return small;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        System.out.println(PrintAllTheDevsiors(n));
    }
}
