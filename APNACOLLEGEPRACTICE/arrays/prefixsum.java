package arrays;

public class prefixsum {

    public static void checkprefixsum(int[] numbers) {
        int n = numbers.length;
        int[] prefix = new int[n];
        int max = Integer.MIN_VALUE;
        int currentsum;

        // Step 1: Create prefix sum array
        prefix[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        // Step 2: Find max subarray sum using prefix
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                currentsum = (start == 0) ? prefix[end] : prefix[end] - prefix[start - 1];
                System.out.println("Subarray (" + start + " to " + end + ") sum: " + currentsum);
                if (currentsum > max) {
                    max = currentsum;
                }
            }
        }

        System.out.println("Maximum Subarray Sum = " + max);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        checkprefixsum(numbers);
    }
}
 