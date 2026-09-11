import java.util.Scanner;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maximumSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            if (currentSum > maximumSum) {
                maximumSum = currentSum;
            }
        }

        return maximumSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);

        scanner.close();
    }
}