import java.util.ArrayList;
import java.util.Comparator;

public class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // 🔍 Searching
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // 🔎 Filtering
    public void showAvailableBooks() {
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        }
    }

    // 🔃 Sorting
    public void sortBooksByTitle() {
        books.sort(Comparator.comparing(Book::getTitle));
    }

    public void showAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
