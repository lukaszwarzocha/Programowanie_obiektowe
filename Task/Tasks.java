package Task;

import java.util.Random;
import java.util.Scanner;

public class Tasks {

    public String Task1(){return "Lukasz, 20";}

    public void Task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj pierwsza liczbe:");
        double liczba1 = scanner.nextDouble();
        System.out.println("Podaj druga liczbe:");
        double liczba2 = scanner.nextDouble();
        operacjenaliczbach(liczba1, liczba2);
    }
    private void operacjenaliczbach(double a, double b) {
        System.out.println("Suma:" +(a+b));
        System.out.println("Różnica: " +(a-b));
        System.out.println("Iloczyn:" +(a*b));
    }

    public String Task3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe:");
        int liczba = scanner.nextInt();

        if(liczba%2==0){
            return "true";}
            return "false";
    }

    public String Task4(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe:");
        int liczba = scanner.nextInt();

        if(liczba%3==0 && liczba%5==0){
            return "true";}
            return "false";
    }

    public String Task5(){
        Scanner scanner = new Scanner(System.in);
        double liczba2 = 3;
        double wynik;
        System.out.println("Podaj liczbe:");
        double liczba = scanner.nextDouble();
        wynik = Math.pow(liczba, liczba2);
        return String.valueOf(wynik);
    }


    public String Task6(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe:");
        double wynik;
        double liczba = scanner.nextDouble();
        wynik = Math.sqrt(liczba);
        return String.valueOf(wynik);
    }

    public boolean Task7() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Podaj przedzial dolny a:");
        int a = scanner.nextInt();
        System.out.println("Podaj przedzial gorny b:");
        int b = scanner.nextInt();

        int boka = (int) (a + rand.nextDouble() * (b - a));
        int bokb = (int) (a + rand.nextDouble() * (b - a));
        int bokc = (int) (a + rand.nextDouble() * (b - a));

        System.out.println("Wylosowane dlugosci bokow to a= " + boka + ", b= " + bokb + ", c= " + bokc);

        if (czytrojkatprostokatny(boka, bokb, bokc)) {
            return true;
        } else {
            return false;
        }
    }
        private boolean czytrojkatprostokatny(double a, double b, double c) {
            double[] boki = {a,b,c};
            java.util.Arrays.sort(boki);
            return Math.pow(boki[0], 2) + Math.pow(boki[1], 2) == Math.pow(boki[2], 2);

        }
    }

