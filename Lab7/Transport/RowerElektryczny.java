package Transport;

public class RowerElektryczny extends Pojazd implements Elektryczny{


    private int poziomBaterii = 100;

    public RowerElektryczny(String id, String model) {
        super(id,model);
    }


    @Override
    public void naladuj() {
        poziomBaterii = 100;
    }

    @Override
    public int poziomNaladowania() {
        return poziomBaterii;

    }

    @Override
    public double Obliczkoszt(int liczbaGodzin) {
        return liczbaGodzin * 10.0;
    }
}
