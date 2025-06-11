package Task;

import Budynki.Budynek;
import Figury.*;
import Gatunki.Gatunek;

import java.util.Scanner;

public class Tasks {
    public void Task1() {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Podaj numer figury ktora wybierasz:\n");
            System.out.println("1: Kolo");
            System.out.println("2: Kwadrat");
            System.out.println("3: Prostakat");
            System.out.println("4: Szescian");
            System.out.println("5: Prostopadlosian");
            System.out.println("6: Kula");
            System.out.println("7: Stozek \n");

            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    System.out.println("Podaj promien kola:\n");
                    double r = scanner.nextDouble();
                    Kolo kolo = new Kolo(r);
                    System.out.println("Wszystkie dane:\n");
                    kolo.WyswietlDane();
                    break;
                case 2:
                    System.out.println("Podaj dlugosc boku a:\n");
                    double a = scanner.nextDouble();
                    Kwadrat kwadrat = new Kwadrat(a);
                    System.out.println("Wszystkie dane:\n");
                    kwadrat.WyswietlDane();
                    break;
                case 3:
                    System.out.println("Podaj dlugosc boku a:\n");
                    double boka = scanner.nextDouble();
                    System.out.println("Podaj dlugosc boku b:\n");
                    double bokb = scanner.nextDouble();
                    Prostokat prostokat = new Prostokat(boka, bokb);
                    System.out.println("Wszystkie dane:\n");
                    prostokat.WyswietlDane();
                    break;
                case 4:
                    System.out.println("Podaj dlugosc boku a:\n");
                    double boka2 = scanner.nextDouble();
                    Szescian szescian = new Szescian(boka2);
                    System.out.println("Wszystkie dane:\n");
                    szescian.WyswietlDane();
                    break;
                case 5:
                    System.out.println("Podaj dlugosc boku a:\n");
                    double boka3 = scanner.nextDouble();
                    System.out.println("Podaj dlugosc boku b:\n");
                    double bokb3 = scanner.nextDouble();
                    System.out.println("Podaj dlugosc boku a:\n");
                    double h = scanner.nextDouble();
                    Prostopadloscian prostopadloscian = new Prostopadloscian(bokb3, boka3, h);
                    System.out.println("Wszystkie dane:\n");
                    prostopadloscian.WyswietlDane();
                    break;
                case 6:
                    System.out.println("Podaj promien kuli:\n");
                    double r2 = scanner.nextDouble();
                    Kula kula = new Kula(r2);
                    System.out.println("Wszystkie dane:\n");
                    kula.WyswietlDane();
                    break;
                case 7:
                    System.out.println("Podaj promien stozka:\n");
                    double r3 = scanner.nextDouble();
                    System.out.println("Podaj wysokosc stozka:\n");
                    double h2 = scanner.nextDouble();
                    System.out.println("Podaj wartosc tworzacej l:\n");
                    double l = scanner.nextDouble();
                    Stozek stozek = new Stozek(r3, h2, l);
                    System.out.println("Wszystkie dane:\n");
                    stozek.WyswietlDane();
                    break;
                default:
                    System.out.println("Nie znaleziono figury");
            }
        }
        public void Task2() {
        Budynek budynek1 = new Budynek("Budynek1",6,1978);
        System.out.println("Dane budynku 1:");
        budynek1.WyswietlDane();

        Budynek budynek2 = new Budynek("Budynek2",10,2000);
        System.out.println("Dane budynku 2:");
        budynek2.WyswietlDane();

        Budynek budynek3 = new Budynek("Budynek3",15,2018);
        System.out.println("Dane budynku 3:");
        budynek3.WyswietlDane();

        }
        public void Task3() {
            Gatunek gatunek1 = new Gatunek("Felis","Catus",38,19,"Zwierze domowe");
            System.out.println("Dane gatunku 1:");
            gatunek1.WyswietlDane();

            System.out.println("Pelna nazwa gatunku 1: "+gatunek1.pelna_nazwa());
            System.out.println("Haploidalna liczba chromosomow gatunku 1: "+gatunek1.liczba_chromosomow_haploidalnych());
        }
    }

