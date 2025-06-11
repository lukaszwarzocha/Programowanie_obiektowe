package Figury;

public class Prostokat {
    private double a, b;
    private String nazwa;

    public Prostokat(double a, double b) {
        this.a = a;
        this.b = b;
        this.nazwa = "Prostokat";
    }

    public double getB() {
        return b;
    }

    public double getA() {
        return a;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double obliczObwod() {
        return 2*a+2*b;
    }

    public double obliczPole() {
        return a*b;
    }

    public void WyswietlDane() {
        System.out.println("Nazwa figury to: "+ nazwa);
        System.out.println("Bok a wynosi: "+ a);
        System.out.println("Bok b wynosi: "+ b);
        System.out.println("Obwod figury to: "+ obliczObwod());
        System.out.println("Pole figury to: "+ obliczPole());
    }

}


