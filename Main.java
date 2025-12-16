public class Main {
    public static void main(String[] args) {

        Library myLibrary = new Library("City Library");


        Book book1 = new Book("1984", "George Orwell", "12345");
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien", "67890");


        LibraryUser user1 = new LibraryUser("Alice", 1);
        LibraryUser user2 = new LibraryUser("Bob", 2);


        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addUser(user1);
        myLibrary.addUser(user2);


        myLibrary.borrowBook(user1, book1);
        myLibrary.borrowBook(user2, book1);


        myLibrary.displayLibrary();
    }
}
