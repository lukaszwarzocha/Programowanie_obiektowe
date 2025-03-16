package Figury;

public class Kwadrat {
    private double a;
    private String nazwa;

public Kwadrat(double a) {
    this.a = a;
    this.nazwa = "Kwadrat";
    }

    public double getA() {
        return a;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double obliczObwod() {
        return 4*a;
    }

    public double obliczPole() {
        return a*a;
    }

    public void WyswietlDane() {
        System.out.println("Nazwa figury to: "+ nazwa);
        System.out.println("Dlugosc boku a to: "+ a);
        System.out.println("Obwod figury to: "+ obliczObwod());
        System.out.println("Pole figury to: "+ obliczPole());
    }
}
