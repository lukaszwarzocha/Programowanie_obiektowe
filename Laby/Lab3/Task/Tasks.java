package Task;

import java.util.Random;
import java.util.Scanner;


public class Tasks {

    public void Task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe studentow: \n");
        int liczba_studentow = scanner.nextInt();
        int i = 0;
        int sumapunktow = 0;
        while (i < liczba_studentow) {
            System.out.println("Podaj liczbe punktow dla studenta " + (i + 1) + "\n");
            int punkty = scanner.nextInt();
            sumapunktow += punkty;
            i++;
        }
        double srednia = sumapunktow / liczba_studentow;
        System.out.println("Srednia wynosi: " + srednia);
    }

    public void Task2() {
        Scanner scanner = new Scanner(System.in);
        int[] liczby = new int[10];
        int liczby_dodatanie = 0;
        int liczby_ujemne = 0;
        int wszystkie_dodatnie = 0;
        int wszystkie_ujemne = 0;

        System.out.println("Podaj 10 liczb");
        for (int i = 0; i < 10; i++) {
            System.out.println("Liczba " + (i + 1) + ": \n");
            liczby[i] = scanner.nextInt();

            if (liczby[i] > 0){
            liczby_dodatanie++;
            wszystkie_dodatnie += liczby[i];
            }
            else if (liczby[i] < 0){
                liczby_ujemne++;
                wszystkie_ujemne += liczby[i];
            }
        }
        System.out.println("Ilosc liczb dodatnich wynosi: " +liczby_dodatanie + "\n");
        System.out.println("Suma liczb dodatnich wynosi: " +wszystkie_dodatnie + "\n");
        System.out.println("Ilosc liczb ujemnych wynosi;" +liczby_ujemne + "\n");
        System.out.println("Suma liczb ujemnych wynosi: " +wszystkie_ujemne);
    }

public void Task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ilosc liczb n: \n");
        int n = scanner.nextInt();
        int suma_liczb_parzystych = 0;

        for(int i = 0; i < n; i++){
            System.out.println("Podaj liczbe " + (i + 1) + ": \n");
            int liczba = scanner.nextInt();

            if (liczba % 2 == 0){
            suma_liczb_parzystych += liczba;
            }
        }
        System.out.println("Suma liczb parzystych w ciagu n wynosi: "+ suma_liczb_parzystych);
}

public void Task4() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Podaj ilosc liczb n: \n");
        int n = scanner.nextInt();
        int suma_liczb_parzystych = 0;

        for(int i = 0; i < n; i++){
            int liczba = rand.nextInt(56)-10;

            if (liczba % 2 == 0){
                suma_liczb_parzystych += liczba;
            }
    }
    System.out.println("Suma liczb parzystych w ciagu n wynosi: "+ suma_liczb_parzystych);
}

public String Task5() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj slowo: \n");
    String word = scanner.next();

    if (czyPalindrom(word)) {
        return "To palindrom";
    } else {
       return "To nie jest palindrom";
    }
}

        public static boolean czyPalindrom(String word){
            int dlugosc = word.length();
            for (int i = 0; i < dlugosc /2; i++) {
                if (word.charAt(i) != word.charAt(dlugosc-1-i)) {
                    return false;
                }
            }
            return true;
    }


}
