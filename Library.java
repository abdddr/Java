import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> books;
    private ArrayList<LibraryUser> users;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Add book
    public void addBook(Book book) {
        books.add(book);
    }


    public void addUser(LibraryUser user) {
        users.add(user);
    }

    public void borrowBook(LibraryUser user, Book book) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            System.out.println(user.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " Is already borrowed.");
        }
    }

    public void displayLibrary() {
        System.out.println("Library: " + name);
        System.out.println("Books:");
        for (Book book : books) {
            book.displayInfo();
        }
        System.out.println("Users:");
        for (LibraryUser user : users) {
            user.displayInfo();
        }
    }
}