class Student {
    String name;
    double attendance;

    static String collegeName = "SRM University";
    static int studentCount = 0;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println("College Name: " + collegeName);
        System.out.println("Student Count: " + studentCount);
    }
}

public class CollegeInformation {
    public static void main(String[] args) {
        Student s1 = new Student("Riya", 85.5);
        Student s2 = new Student("Arjun", 90.0);

        Student.printCollegeInfo();
    }
}