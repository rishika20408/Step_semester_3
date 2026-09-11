import java.util.Scanner;

public class FindMinimumRotatedArray {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] < nums[right]) {
                return nums[left];
            }

            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter rotated sorted array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = findMin(nums);

        System.out.println("Minimum Element: " + result);

        scanner.close();
    }
}