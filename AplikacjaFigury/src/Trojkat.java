public class Trojkat extends FiguraGeometryczna {
    private double a, b, c; // boki trójkąta
    private double wysokosc; // wysokość na bok a

    public Trojkat(double a, double b, double c, double wysokosc) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0 || wysokosc <= 0) {
            throw new IllegalArgumentException("Boki i wysokość muszą być większe od 0.");
        }
        if (!czyTrojkatIstnieje(a, b, c)) {
            throw new IllegalArgumentException("Podane boki nie tworzą trójkąta.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.wysokosc = wysokosc;
    }

    private boolean czyTrojkatIstnieje(double a, double b, double c) {
        return (a + b > c) && (b + c > a) && (a + c > b);
    }

    @Override
    public double obliczPole() {
        return 0.5 * a * wysokosc;
    }

    @Override
    public double obliczObwod() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Trójkąt: bok a = " + a + ", bok b = " + b + ", bok c = " + c +
               ", wysokość = " + wysokosc + ", pole = " + obliczPole() + ", obwód = " + obliczObwod();
    }
}