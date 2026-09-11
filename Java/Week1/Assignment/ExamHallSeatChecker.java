import java.util.Scanner;

public class ExamHallSeatChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {

                    boolean alreadyPrinted = false;

                    for (int k = 0; k < i; k++) {
                        if (seatNumbers[k] == seatNumbers[i]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }

                    if (!alreadyPrinted) {
                        System.out.println(
                                "Duplicate Seat Number Found: " + seatNumbers[i]);
                        duplicateFound = true;
                    }
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        int[] seatNumbers = new int[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter seat number " + (i + 1) + ": ");
            seatNumbers[i] = scanner.nextInt();
        }

        checkDuplicateSeats(seatNumbers);

        scanner.close();
    }
}