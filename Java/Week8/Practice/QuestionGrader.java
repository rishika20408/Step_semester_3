import java.util.*;

abstract class Question {
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TF extends Question {
    TF(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class Essay extends Question {
    Essay(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();
            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            String[] lastPart = parts[6].trim().split(" ");
            double points = Double.parseDouble(lastPart[lastPart.length - 1]);

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ(correctAnswer, studentAnswer, points);
            } else if (type.equals("TF")) {
                question = new TF(correctAnswer, studentAnswer, points);
            } else {
                question = new Essay(correctAnswer, studentAnswer, points);
            }

            double score = question.grade();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}