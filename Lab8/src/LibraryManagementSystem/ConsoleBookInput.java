package LibraryManagementSystem;

import java.util.Scanner;

public class ConsoleBookInput implements BookInput{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Book readBook() throws InvalidBookException {
        System.out.println("Wprowadz nazwe ksiazki:");
        String title = scanner.nextLine();

        System.out.println("Wprowadz autora:");
        String author = scanner.nextLine();

        System.out.println("Wprowadz ISBN:");
        String isbn = scanner.nextLine();

        return new Book(title, author, isbn);
    }
}
