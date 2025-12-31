public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;


    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public boolean isBorrowed() { return isBorrowed; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }


    public void displayInfo() {
        System.out.println("book: " + title + " | Author: " + author + " | ISBN: " + isbn + " | Borrowed: " + isBorrowed);
    }
}

