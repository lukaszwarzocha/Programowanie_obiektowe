package Figury;

public class Kolo {

    private String nazwa;
  private double promien;

    public Kolo(double promien) {
        this.nazwa = "Kolo";
        this.promien = promien;
    }

    public double obliczObwod() {
        return Math.PI * 2 * promien;
    }

    public double obliczPole() {
        return Math.PI * Math.pow(promien, 2);
    }

    public void WyswietlDane() {
        System.out.println("Nazwa figury to: "+ nazwa);
        System.out.println("Promien figury to: "+ promien);
        System.out.println("Obwod figury to: "+ obliczObwod());
        System.out.println("Pole figury to: "+ obliczPole());
    }
}

