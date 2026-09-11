import java.util.Scanner;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {

        int length = nums.length;
        k = k % length;

        int[] newArray = new int[length];

        for (int i = 0; i < length; i++) {
            int newPosition = (i + k) % length;
            newArray[newPosition] = nums[i];
        }

        return newArray;
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

        System.out.print("Enter rotation value: ");
        int k = scanner.nextInt();

        int[] result = rotateArray(nums, k);

        printArray(result);

        scanner.close();
    }
}