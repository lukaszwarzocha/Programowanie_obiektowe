package Figury;

public class Kula {

    private String nazwa;
    private double r;

    public Kula(double r) {
        this.nazwa = "Kula";
        this.r = r;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getR() {
        return r;
    }

    public double ObliczPole(){
        return 4*Math.PI*Math.pow(r,2);
    }

    public double ObliczObjetosc(){
        return 4/3*Math.PI*Math.pow(r,3);
    }

    public void WyswietlDane() {
        System.out.println("Nazwa figury to: "+ nazwa);
        System.out.println("Promien wynosi: "+ r);
        System.out.println("Pole calkowite figury to: "+ ObliczPole());
        System.out.println("Objetosc figury to: "+ ObliczObjetosc());
    }
}
