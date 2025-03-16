package Figury;

public class Szescian {

    private double a;
    private String nazwa;

    public Szescian(double a) {
        this.a = a;
        this.nazwa = "Szescian";
    }

    public double getA() {
        return a;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double ObliczObjetosc() {
        return Math.pow(a, 3);
    }

    public double ObliczPole() {
        return 6 * Math.pow(a, 2);
    }

    public void WyswietlDane() {
        System.out.println("Nazwa figury to: "+ nazwa);
        System.out.println("Bok a wynosi: "+ a);
        System.out.println("Pole calkowite figury to: "+ ObliczPole());
        System.out.println("Objetosc figury to: "+ ObliczObjetosc());
    }
}
