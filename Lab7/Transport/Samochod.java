package Transport;

public class Samochod extends Pojazd {

    public Samochod(String id, String model) {
        super(id, model);
    }

    @Override
    public double Obliczkoszt(int liczbaGodzin) {
        return liczbaGodzin * 25.0;
    }
}
