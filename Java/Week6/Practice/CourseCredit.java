class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }
}

public class CourseCredit {
    public static void main(String[] args) {
        Course theoryCourse = new Course("CS101", "Java Programming", 3);
        Course labCourse = new Course("CS102", "Java Lab", 2, 1);

        System.out.println(theoryCourse.title + ": " + theoryCourse.totalCredits());
        System.out.println(labCourse.title + ": " + labCourse.totalCredits());
    }
}