import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ZarzadcaFigur {
    private List<FiguraGeometryczna> figury;

    public ZarzadcaFigur() {
        figury = new ArrayList<>();
    }

    public void dodajFigure(FiguraGeometryczna figura) {
        figury.add(figura);
    }

    public void wyswietlFigury() {
        if (figury.isEmpty()) {
            System.out.println("Lista figur jest pusta.");
        } else {
            for (int i = 0; i < figury.size(); i++) {
                System.out.println((i + 1) + ". " + figury.get(i));
            }
        }
    }

    public void serializujDoPliku(String nazwaPliku) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nazwaPliku))) {
            oos.writeObject(figury);
            System.out.println("Zapisano figury do pliku: " + nazwaPliku);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu do pliku: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void deserializujZPliku(String nazwaPliku) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nazwaPliku))) {
            figury = (List<FiguraGeometryczna>) ois.readObject();
            System.out.println("Wczytano figury z pliku: " + nazwaPliku);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Błąd podczas wczytywania pliku: " + e.getMessage());
        }
    }
}