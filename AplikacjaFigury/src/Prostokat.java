public class Prostokat extends FiguraGeometryczna {
    private double dlugosc;
    private double szerokosc;

    public Prostokat(double dlugosc, double szerokosc) throws IllegalArgumentException {
        if (dlugosc <= 0 || szerokosc <= 0) {
            throw new IllegalArgumentException("Długość i szerokość muszą być większe od 0.");
        }
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
    }

    @Override
    public double obliczPole() {
        return dlugosc * szerokosc;
    }

    @Override
    public double obliczObwod() {
        return 2 * (dlugosc + szerokosc);
    }

    @Override
    public String toString() {
        return "Prostokąt: długość = " + dlugosc + ", szerokość = " + szerokosc +
               ", pole = " + obliczPole() + ", obwód = " + obliczObwod();
    }
}
