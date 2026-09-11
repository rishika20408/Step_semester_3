import java.util.Scanner;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] answer = new int[length];

        int leftProduct = 1;

        for (int i = 0; i < length; i++) {
            answer[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        int rightProduct = 1;

        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    public static void printArray(int[] array) {

        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
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

        int[] result = productExceptSelf(nums);

        printArray(result);

        scanner.close();
    }
}