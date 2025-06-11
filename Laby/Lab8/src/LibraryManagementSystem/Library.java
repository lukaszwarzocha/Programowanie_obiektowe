package LibraryManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            System.out.println("Ksiazka o tym ISBN juz istnieje");
        } else {
            books.put(book.getIsbn(), book);
            System.out.println("Dodales ksiazke: "+book.getTitle());
        }
    }

    public void removeBook(String isbn) {
        if (books.containsKey(isbn)) {
            Book removed = books.remove(isbn);
            System.out.println("Ksiazka zostala usunieta: "+removed.getTitle());
        } else {
            System.out.println("Nie znaleziono ksiazki o podanym ISBN: "+isbn);
        }
    }

    public void editBook(String isbn, Book updatedBook) {
        if (books.containsKey(isbn)) {
            books.put(isbn, updatedBook);
            System.out.println("Zmieniono dane ksiazki");
        } else {
            System.out.println("Nie znaleziono ksiazki o podanym ISBN: "+isbn);
        }
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Brak ksiazek w bibliotece");
            return;
        }
        System.out.println("Lista ksiazek:");
        for (Book book : books.values()) {
            System.out.println(book.getTitle()+", "+book.getAuthor()+" ISBN: "+book.getIsbn()+" '");
        }
    }

    public void findBook(String isbn) {
        if (books.containsKey(isbn)) {
            Book book = books.get(isbn);
            System.out.println("Znaleziona ksiazka to:"+book.getTitle()+
                    ","+book.getAuthor()+ "ISBN: "+book.getIsbn()+"'");
        } else {
            System.out.println("Nie ma ksiazki o podanym ISBN");
        }
    }
}