import java.io.Serializable;

public abstract class FiguraGeometryczna implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract double obliczPole();
    public abstract double obliczObwod();
    public abstract String toString();
}