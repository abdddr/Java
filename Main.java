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

        System.out.println("=== All books ===");
        library.showAllBooks();

        System.out.println("\n=== Available books ===");
        library.showAvailableBooks();

        System.out.println("\n=== Borrowing book ===");
        Book found = library.findBookByTitle("1984");
        if (found != null && !found.isBorrowed()) {
            user.borrowBook(found);
        }

        System.out.println("\n=== Sorted books ===");
        library.sortBooksByTitle();
        library.showAllBooks();
    }
}
