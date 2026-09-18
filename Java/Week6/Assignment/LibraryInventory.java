class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Copies Available: " + copiesAvailable);
        System.out.println();
    }
}

public class LibraryInventory {
    public static void main(String[] args) {
        BookInventory[] books = {
            new BookInventory("Harry Potter", "J.K. Rowling", 5),
            new BookInventory("The Alchemist", "Paulo Coelho", 3),
            new BookInventory("1984", "George Orwell", 4),
            new BookInventory("Wings of Fire", "A.P.J. Abdul Kalam", 6)
        };

        for (BookInventory book : books) {
            book.printEntry();
        }
    }
}