package Testowanie;

public class Kwadrat implements FiguraGeometryczna {

    private double a = 3;

    @Override
    public double Pole() {
        return a*a;
    }

    @Override
    public double Obwod() {
        return 4*a;
    }


}
