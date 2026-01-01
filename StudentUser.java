public class StudentUser extends LibraryUser {

    public StudentUser(String name, int userId) {
        super(name, userId);
    }

    @Override
    public void borrowBook(Book book) {
        System.out.println("student     " + name + " borrowed " + book.getTitle());
        book.setBorrowed(true);
    }
}
