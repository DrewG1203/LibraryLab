import java.util.*;

public class Library {
    // Add the missing implementation to this class
    private String address;
    private static String hours = "Libraries are open daily from 9am to 5pm.";
    private ArrayList<Book> books;

    Library (String location) {
        this.address = location;
        this.books = new ArrayList<Book>();
    }
    public void addBook(Book newBook) {
        this.books.add(newBook);
    }
    public static void printOpeningHours() {
        System.out.println(hours);
    }
    public void printAddress() {
        System.out.println(this.address);
    }

    public void borrowBook(String title) {
        boolean findBook = false;
        for(Book bok: this.books) {
            findBook = true;
            if(bok.isBorrowed()) {
                System.out.println("Sorry, this book in not available");
            } else {
                bok.borrowed();
                System.out.printf("You've successfully borrowed %s.\n", title);
            }
        }
    if(!findBook) {
        System.out.println("Sorry, we do not have this book.");
    }
    }

    public void printAvailableBooks() {
        if(this.books.isEmpty()) {
            System.out.println("Catalog is empty.");
        } else {
            for (Book bok: this.books) {
                if(!bok.isBorrowed()) {
                    System.out.println(bok.title);
                }
            }
        }
    }

    public void returnBook(String title) {
        for (Book bok: this.books) {
            if(bok.title.equals(title)) {
                bok.returned();
                System.out.printf("You have returned %s.\n", title);
                return;
            }
        }
        System.out.println("We can not return this book to this location.");
    }


    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}