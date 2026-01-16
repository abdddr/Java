import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASSWORD);
    }

    // CREATE (write)
    public void addBook(Book book) throws SQLException {
        String sql = """
                INSERT INTO books (isbn, title, author, is_borrowed)
                VALUES (?, ?, ?, ?)
                ON CONFLICT (isbn) DO NOTHING
                """;

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, book.getIsbn());      // добавь getIsbn() в Book
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());    // добавь getAuthor() в Book
            ps.setBoolean(4, book.isBorrowed());
            ps.executeUpdate();
        }
    }

    // READ
    public List<Book> getAllBooks() throws SQLException {
        String sql = "SELECT isbn, title, author, is_borrowed FROM books ORDER BY title";
        List<Book> list = new ArrayList<>();

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Book b = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn")
                );
                b.setBorrowed(rs.getBoolean("is_borrowed"));
                list.add(b);
            }
        }
        return list;
    }

    // UPDATE (например поменять borrowed)
    public void setBorrowed(String isbn, boolean borrowed) throws SQLException {
        String sql = "UPDATE books SET is_borrowed = ? WHERE isbn = ?";

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setBoolean(1, borrowed);
            ps.setString(2, isbn);
            ps.executeUpdate();
        }
    }

    // DELETE
    public void deleteByIsbn(String isbn) throws SQLException {
        String sql = "DELETE FROM books WHERE isbn = ?";

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, isbn);
            ps.executeUpdate();
        }
    }

    // Borrow book (update + borrowed_by)
    public boolean borrowBook(String isbn, int userId) throws SQLException {
        // берём книгу только если она сейчас не взята
        String sql = """
                UPDATE books
                SET is_borrowed = TRUE, borrowed_by = ?
                WHERE isbn = ? AND is_borrowed = FALSE
                """;

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setString(2, isbn);
            int updated = ps.executeUpdate();
            return updated == 1; // true если реально удалось взять
        }
    }

    public void returnBook(String isbn) throws SQLException {
        String sql = """
                UPDATE books
                SET is_borrowed = FALSE, borrowed_by = NULL
                WHERE isbn = ?
                """;
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, isbn);
            ps.executeUpdate();
        }
    }
}
