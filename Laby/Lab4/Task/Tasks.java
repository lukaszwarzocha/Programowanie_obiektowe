package Task;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Tasks {

    public void Task1() {
        Scanner scanner = new Scanner(System.in);
        int[] tablica = new int[10];
        int suma = 0;

        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = losowanieliczb();
        }

        for (int i = 0; i < tablica.length; i++) {
            suma += tablica[i];
        }
        double srednia = suma / tablica.length;

        System.out.println("Srednia elementow tablicy:\n " + srednia);
        System.out.println("Suma elementow tablicy:\n " + suma);
    }

    public static int losowanieliczb() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public void Task2() {
        int[] tablica1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] tablica2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        System.out.println("Co drugi element tablicy1");
        for (int i = 0; i < tablica1.length; i += 2) {
            System.out.println(tablica1[i] + "");
        }

        System.out.println("Co drugi element tablicy2");
        for (int j = 0; j < tablica2.length; j += 2) {
            System.out.println(tablica2[j] + "");
        }
    }

        public void Task3 () {
        String[] slowa = {"kot", "ma", "Ale"};

        for (String slowo: slowa){
            System.out.println(slowo.toUpperCase());

        }
    }

    public void Task4() {
        Scanner scanner = new Scanner(System.in);
        String[] slowa = new String[5];
        System.out.println("Podaj 5 slow:");
        for(int i = 0; i < 5; i++){
            slowa[i]=scanner.nextLine();
        }
        for(int i = slowa.length-1; i >= 0; i--){
            String slowoodtylu = zmianaliter(slowa[i]);
            System.out.println(slowoodtylu);
        }
    }

    public static String zmianaliter(String slowa) {
    return new StringBuilder(slowa).reverse().toString();
    }


    public void Task5() {
        Scanner scanner = new Scanner(System.in);
        int[] liczby = new int[8];
        System.out.println("Podaj 8 liczb:");
        for (int i=0; i<8; i++) {
            liczby[i] = scanner.nextInt();
        }
        Arrays.sort(liczby);
        System.out.println("Posortowane liczby:\n");
        for (int liczba: liczby) {
            System.out.println(liczba+ "");
        }
    }


public void Task6() {
        Scanner scanner = new Scanner(System.in);
        int[] liczby = new int[5];
        System.out.println("Podaj 5 liczb:");
        for (int i=0; i<5; i++) {
            liczby[i] = scanner.nextInt();
        }

        for(int liczba: liczby){
            long silniazliczby = silnia(liczba);
            System.out.println("Silnia z "+liczba+" to:"+silniazliczby);
        }

}
public static long silnia(int liczba) {
        if (liczba < 0) {
            System.out.println("Blad");
        }
     if (liczba == 0 || liczba == 1) {
         return 1;
    }
     return liczba * silnia(liczba - 1);
}

public void Task7() {
      String[] slowa1 = {"kot", "ma", "Ale"};
      String[] slowa2 = {"kot", "ma", "Ale"};

      boolean takiesame = true;
     if(slowa1.length != slowa2.length) {
         takiesame = false;
     }

     else {

         for (int i = 0; i < slowa1.length; i++) {
             if (!slowa1[i].equals(slowa2[i])) {
                 takiesame = false;
                 break;
             }
         }
     }


     if (takiesame) {
         System.out.println("Tablice sa takie same");
     }
     else {
         System.out.println("Tablice sa rozne");
     }
     }

}


