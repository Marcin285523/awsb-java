public class Kolo extends FiguraGeometryczna {
    private double promien;

    public Kolo(double promien) throws IllegalArgumentException {
        if (promien <= 0) {
            throw new IllegalArgumentException("Promień musi być większy od 0.");
        }
        this.promien = promien;
    }

    @Override
    public double obliczPole() {
        return Math.PI * promien * promien;
    }

    @Override
    public double obliczObwod() {
        return 2 * Math.PI * promien;
    }

    @Override
    public String toString() {
        return "Koło: promień = " + promien + ", pole = " + obliczPole() + ", obwód = " + obliczObwod();
    }
}