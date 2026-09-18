class IdCard {
    String name;
    int booksIssued;

    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class LibraryIdCard {
    public static void main(String[] args) {
        IdCard first = new IdCard("Riya", 2);

        IdCard alias = first;

        alias.booksIssued = 5;

        System.out.println("First card books issued: " + first.booksIssued);
        System.out.println("alias == first: " + (alias == first));

        IdCard separate = new IdCard("Riya", 5);

        System.out.println("separate == first: " + (separate == first));
    }
}