import java.util.Scanner;

public class MergeSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];

        int index1 = 0;
        int index2 = 0;
        int resultIndex = 0;

        while (index1 < arr1.length && index2 < arr2.length) {

            if (arr1[index1] <= arr2[index2]) {
                result[resultIndex] = arr1[index1];
                index1++;
            } else {
                result[resultIndex] = arr2[index2];
                index2++;
            }

            resultIndex++;
        }

        while (index1 < arr1.length) {
            result[resultIndex] = arr1[index1];
            index1++;
            resultIndex++;
        }

        while (index2 < arr2.length) {
            result[resultIndex] = arr2[index2];
            index2++;
            resultIndex++;
        }

        return result;
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

        System.out.print("Enter size of first array: ");
        int size1 = scanner.nextInt();

        int[] arr1 = new int[size1];

        System.out.println("Enter first sorted array:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int size2 = scanner.nextInt();

        int[] arr2 = new int[size2];

        System.out.println("Enter second sorted array:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[] result = mergeSortedArrays(arr1, arr2);

        printArray(result);

        scanner.close();
    }
}