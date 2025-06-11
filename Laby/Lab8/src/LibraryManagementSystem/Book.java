package LibraryManagementSystem;

public class Book {

    private String title;
    private String author;
    private String isbn;



    public Book(String title, String author, String isbn) throws InvalidBookException {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InvalidBookException {
        if (title == null || title.isEmpty()) {
        throw new InvalidBookException("Musisz podac nazwe ksiazki!");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws InvalidBookException {
        if (author == null || author.isEmpty()) {
            throw new InvalidBookException("Musisz podac autora!");
        }
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) throws InvalidBookException {
        if (isbn == null || isbn.isEmpty()) {
            throw new InvalidBookException("Musisz podac isbn!");
        }
        this.isbn = isbn;
    }
}
