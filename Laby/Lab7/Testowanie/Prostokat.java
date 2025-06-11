package Testowanie;

public class Prostokat extends Figura {

    private double a,b;


    public Prostokat(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double pole() {
        return a*b;
    }

    @Override
    public double obwod() {
        return 2*a+2*b;
    }
}
