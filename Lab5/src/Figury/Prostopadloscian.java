package Figury;

public class Prostopadloscian {

    private String nazwa;
    private double a;
    private double b;
    private double h;

    public Prostopadloscian(double b, double a, double h) {
        this.nazwa = "Szescian";
        this.b = b;
        this.a = a;
        this.h = h;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getH() {
        return h;
    }

    public double ObliczPole() {
        return 2*a*b+2*a*h+2*b*h;
    }

    public double ObliczObjetosc() {
        return a*b*h;
    }

    public void WyswietlDane() {
        System.out.println("Nazwa figury to: "+ nazwa);
        System.out.println("Bok a wynosi: "+ a);
        System.out.println("Bok b wynosi: "+ b);
        System.out.println("Wysokosc wynosi: "+ h);
        System.out.println("Pole calkowite figury to: "+ ObliczPole());
        System.out.println("Objetosc figury to: "+ ObliczObjetosc());
    }
}
