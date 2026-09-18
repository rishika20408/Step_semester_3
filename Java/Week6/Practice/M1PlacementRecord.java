class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Company: " + company);
        System.out.println("Package: " + packageLpa + " LPA");
        System.out.println();
    }
}

public class PlacementRecord {
    public static void main(String[] args) {
        PlacementRecord[] records = {
            new PlacementRecord("Aisha", "Google", 20),
            new PlacementRecord("Rohan", "Microsoft", 18),
            new PlacementRecord("Karan", "Amazon", 15)
        };

        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}