public class LibraryUser {
    protected String name;
    protected int userId;

    public LibraryUser(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        System.out.println(name + " wants to borrow " + book.getTitle());
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', id=" + userId + '}';
    }
}
