package LibraryManagement.Models;

public class Book {
    private final String isbn;
    private final String author;
    private final String title;
    private boolean isAvailable;

    public Book (String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.isAvailable = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
}
