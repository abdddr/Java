import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Library library = new Library("Digital Library");

        Book b1 = new Book("1984", "George Orwell", "111");
        Book b2 = new Book("The Hobbit", "Tolkien", "222");
        Book b3 = new Book("Clean Code", "Robert Martin", "333");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        LibraryUser user = new StudentUser("Alice", 1); // полиморфизм

        System.out.println("=== All books (ArrayList) ===");
        library.showAllBooks();

        System.out.println("\n=== Available books (ArrayList) ===");
        library.showAvailableBooks();

        System.out.println("\n=== Borrowing book (ArrayList) ===");
        Book found = library.findBookByTitle("1984");
        if (found != null && !found.isBorrowed()) {
            user.borrowBook(found);
        }

        System.out.println("\n=== Sorted books (ArrayList) ===");
        library.sortBooksByTitle();
        library.showAllBooks();

        try {
            BookRepository repo = new BookRepository();

            System.out.println("\n\n=== DB: WRITE (insert books) ===");
            repo.addBook(b1);
            repo.addBook(b2);
            repo.addBook(b3);

            System.out.println("\n=== DB: READ (select all) ===");
            List<Book> dbBooks = repo.getAllBooks();
            dbBooks.forEach(System.out::println);

            System.out.println("\n=== DB: UPDATE (set borrowed=true for isbn=111) ===");
            repo.setBorrowed("111", true);

            System.out.println("\n=== DB: READ (after update) ===");
            repo.getAllBooks().forEach(System.out::println);

            System.out.println("\n=== DB: DELETE (delete isbn=222) ===");
            repo.deleteByIsbn("222");

            System.out.println("\n=== DB: READ (after delete) ===");
            repo.getAllBooks().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
