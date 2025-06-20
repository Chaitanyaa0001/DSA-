package arrays;

public class subarrays {

    public static void findSubarrays(int[] numbers) {
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                // Print subarray from index i to j
                for (int k = i; k <= j; k++) {
                    System.out.print(numbers[k] + " ");
                }
                total++;
                System.out.println();
            }
        }
        System.out.println("Total subarrays = " + total);
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9};
        findSubarrays(numbers);
    }
}
