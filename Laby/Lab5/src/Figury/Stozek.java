package Figury;

public class Stozek {
    private String nazwa;
    private double r;
    private double h;
    private double l;
    private double Pp;

    public Stozek(double r, double h, double l) {
        this.nazwa = "Stozek";
        this.r = r;
        this.h = h;
        this.l = l;
        this.Pp = Math.PI * Math.pow(r, 2);
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getL() {
        return l;
    }

    public double getH() {
        return h;
    }

    public double getR() {
        return r;
    }

    public double ObliczPole() {
        return Math.PI * Math.pow(r, 2) + Math.PI * r * l;
    }

    public double ObliczObjetosc() {
        return 1.0/3 * Pp * h;
    }

    public void WyswietlDane() {
        System.out.println("Nazwa figury to: " + nazwa);
        System.out.println("Promien wynosi: " + r);
        System.out.println("Wysokosc wynosi: " + h);
        System.out.println("Tworzaca l wynosi: " + l);
        System.out.println("Pole calkowite figury to: " + ObliczPole());
        System.out.println("Objetosc figury to: " + ObliczObjetosc());
    }
}
