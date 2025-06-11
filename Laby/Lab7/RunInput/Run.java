package RunInput;
import Transport.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
    Scanner scanner;

    public void RunTask() {
        List<Pojazd> pojazdy = new ArrayList<>();
        pojazdy.add(new Samochod("S1", "Toyota"));
        pojazdy.add(new RowerElektryczny("RE001", "Romek"));
        pojazdy.add(new SamochodElektryczny("S22", "Audi"));

        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n **************** Menu ********************");
            System.out.println("1. Wyswietl dostepne pojazdy");
            System.out.println("2. Wypozycz pojazd");
            System.out.println("3. Zwroc pojazd");
            System.out.println("4. Naladuj pojazd elektryczny");
            System.out.println("5. Wyjscie");
            System.out.println("Twoj wybor:");
            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    viewPojazdy(pojazdy);
                    break;
                case 2:
                    wypozyczPojazd(pojazdy);
                    break;
                case 3:
                    zwrocPojazd(pojazdy);
                    break;
                case 4:
                    naladujPojazd(pojazdy);
                    break;
                case 5:
                    System.out.println("Koniec programu.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nie ma takiego wyboru");
            }
        }
    }

    private void naladujPojazd(List<Pojazd> pojazdy) {
        System.out.println("Podaj id pojazdu do ladowania");
        String idladuj = scanner.nextLine();

        for (Pojazd p : pojazdy) {
            if (p.getId().equals(idladuj) && p instanceof Elektryczny) {
                ((Elektryczny) p).naladuj();
                System.out.println("Pojazd naladowany do 100%");
                return;
            }
        }
        System.out.println("Nie znaleziono pojazdu elektrycznego o podanym ID");
    }

    private void zwrocPojazd(List<Pojazd> pojazdy) {
        System.out.println("Podaj id pojazdu");
        String idsamochodu = scanner.nextLine();

        for (Pojazd p : pojazdy) {
            if(p.getId().equals(idsamochodu)) {
                if (!p.isCzyDostepny()) {
                    p.zwroc();
                    System.out.println("Zwracasz pojazd " + p.getId());
                } else {
                    System.out.println("Ten pojazd nie jest wypozyczony");
                }
                return;
            }
        }
        System.out.println("Nie znaleziono pojazdu o podanym ID");
    }

    private void wypozyczPojazd(List<Pojazd> pojazdy) {
        System.out.println("Podaj ID");
        String idWyp = scanner.nextLine();

        for (Pojazd p : pojazdy) {
            if (p.getId().equals(idWyp)) {
                if (p.isCzyDostepny()) {
                    System.out.println("Na ile godzin chcesz wypozyczyc pojazd");
                    int godziny = scanner.nextInt();
                    scanner.nextLine();
                    p.wypozycz();
                    System.out.println("Koszt wypozyczenia " + p.Obliczkoszt(godziny) + "zł");
                } else {
                    System.out.println("Pojazd jest juz wypozyczony");
                }
                return;
            }
        }
        System.out.println("Nie znaleziono pojazdu o podanym ID");
    }

    private void viewPojazdy(List<Pojazd> pojazdy) {
        for (Pojazd p : pojazdy) {
            System.out.println(p.getId() + " " + p.getModel() + " " +
                    (p.isCzyDostepny() ? "Dostepny" : "Zajety"));
        }
    }
}