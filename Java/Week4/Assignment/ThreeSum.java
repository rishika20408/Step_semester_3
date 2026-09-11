import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {

    public static int[][] threeSum(int[] nums) {

        Arrays.sort(nums);

        int[][] temporaryResult = new int[nums.length * nums.length][3];
        int resultCount = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    temporaryResult[resultCount][0] = nums[i];
                    temporaryResult[resultCount][1] = nums[left];
                    temporaryResult[resultCount][2] = nums[right];

                    resultCount++;

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        int[][] result = new int[resultCount][3];

        for (int i = 0; i < resultCount; i++) {
            result[i][0] = temporaryResult[i][0];
            result[i][1] = temporaryResult[i][1];
            result[i][2] = temporaryResult[i][2];
        }

        return result;
    }

    public static void printResult(int[][] result) {

        System.out.print("[");

        for (int i = 0; i < result.length; i++) {

            System.out.print("["
                    + result[i][0] + ", "
                    + result[i][1] + ", "
                    + result[i][2] + "]");

            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
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

        int[][] result = threeSum(nums);

        printResult(result);

        scanner.close();
    }
}