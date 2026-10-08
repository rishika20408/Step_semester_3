class Attendance {
    private String[] students;
    private int presentCount;

    Attendance(int size) {
        students = new String[size];
        presentCount = 0;
    }

    void markPresent(String name) {
        if (!isPresent(name) && presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        }
    }

    int getPresentCount() {
        return presentCount;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class AttendanceSheet {
    public static void main(String[] args) {
        Attendance sheet = new Attendance(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: " + sheet.getPresentCount());
        System.out.println("Ben: " + sheet.isPresent("Ben"));
        System.out.println("Chen: " + sheet.isPresent("Chen"));
    }
}