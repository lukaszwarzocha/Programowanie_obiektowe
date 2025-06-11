package RunInput;

import LibraryManagementSystem.Book;
import LibraryManagementSystem.ConsoleBookInput;
import LibraryManagementSystem.InvalidBookException;
import LibraryManagementSystem.Library;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;

public class Run {
   private Library library;
   private Scanner scanner;
   private ConsoleBookInput bookInput;

   public Run() {
       this.library = new Library();
       this.scanner = new Scanner(System.in);
       this.bookInput = new ConsoleBookInput();
   }

    public void RunTask() throws InvalidBookException {
        library.addBook(new Book("Maly ksiaze","Antoine de Saint-Exupéry","242952952"));
        library.addBook(new Book("Kamienie na szaniec", "Aleksander Kaminski","249581818"));
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n **************** Menu ********************");
            System.out.println("1. Wyswietl wszystkie ksiazki");
            System.out.println("2. Dodaj ksiazke");
            System.out.println("3. Usun ksiazke");
            System.out.println("4. Zmien tytul ksiazki");
            System.out.println("5. Znajdz ksiazke");
            System.out.println("6. Zakoncz");
            System.out.println("Twoj wybor:");
            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    library.listBooks();
                    break;
                case 2:
                    try {
                        Book newBook = bookInput.readBook();
                        library.addBook(newBook);
                    }
                    catch (InvalidBookException e) {
                        System.out.println("Błąd: "+e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Podaj ISBN ksiazki ktora chcesz usunac:");
                    String ISBN = scanner.nextLine();
                    library.removeBook(ISBN);
                    break;
                case 4:
                    System.out.println("Podaj ISBN ksiazki ktorej tytul chcesz zmienic");
                    String ISBN2 = scanner.nextLine();
                    try {
                        System.out.println("Podaj nowe dane:");
                        Book readBook = bookInput.readBook();
                        library.editBook(ISBN2, readBook);
                    } catch (InvalidBookException e) {
                        System.out.println("Błąd: "+e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Podaj ISBN ksiazki ktora chcesz znalezc:");
                    String ISBN3 = scanner.nextLine();
                    library.findBook(ISBN3);
                    break;
                case 6:
                    System.out.println("Koniec");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nie ma takiego wyboru");
            }
        }
    }
}

