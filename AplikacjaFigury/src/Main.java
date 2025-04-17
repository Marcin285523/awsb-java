import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ZarzadcaFigur zarzadca = new ZarzadcaFigur();

    public static void main(String[] args) {
        while (true) {
            wyswietlMenu();
            int wybor = pobierzLiczbe("Wybierz opcję: ", 0, 5);
            switch (wybor) {
                case 1:
                    dodajFigure();
                    break;
                case 2:
                    zarzadca.wyswietlFigury();
                    break;
                case 3:
                    serializuj();
                    break;
                case 4:
                    deserializuj();
                    break;
                case 0:
                    System.out.println("Zakończono program.");
                    return;
                default:
                    System.out.println("Nieprawidłowa opcja.");
            }
        }
    }

    private static void wyswietlMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Dodaj figurę");
        System.out.println("2. Wyświetl wszystkie figury");
        System.out.println("3. Zapisz figury do pliku");
        System.out.println("4. Wczytaj figury z pliku");
        System.out.println("0. Wyjdź");
    }

    private static int pobierzLiczbe(String komunikat, int min, int max) {
        while (true) {
            System.out.print(komunikat);
            try {
                int liczba = Integer.parseInt(scanner.nextLine());
                if (liczba >= min && liczba <= max) {
                    return liczba;
                } else {
                    System.out.println("Wprowadź liczbę z zakresu " + min + "-" + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź poprawną liczbę całkowitą.");
            }
        }
    }

    private static double pobierzDouble(String komunikat) {
        while (true) {
            System.out.print(komunikat);
            try {
                double liczba = Double.parseDouble(scanner.nextLine());
                if (liczba > 0) {
                    return liczba;
                } else {
                    System.out.println("Wprowadź liczbę większą od 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź poprawną liczbę.");
            }
        }
    }

    private static void dodajFigure() {
        System.out.println("\nWybierz figurę:");
        System.out.println("1. Prostokąt");
        System.out.println("2. Trójkąt");
        System.out.println("3. Koło");
        int wybor = pobierzLiczbe("Wybierz figurę (1-3): ", 1, 3);

        try {
            switch (wybor) {
                case 1:
                    double dlugosc = pobierzDouble("Podaj długość: ");
                    double szerokosc = pobierzDouble("Podaj szerokość: ");
                    zarzadca.dodajFigure(new Prostokat(dlugosc, szerokosc));
                    System.out.println("Dodano prostokąt.");
                    break;
                case 2:
                    double a = pobierzDouble("Podaj bok a: ");
                    double b = pobierzDouble("Podaj bok b: ");
                    double c = pobierzDouble("Podaj bok c: ");
                    double wysokosc = pobierzDouble("Podaj wysokość na bok a: ");
                    zarzadca.dodajFigure(new Trojkat(a, b, c, wysokosc));
                    System.out.println("Dodano trójkąt.");
                    break;
                case 3:
                    double promien = pobierzDouble("Podaj promień: ");
                    zarzadca.dodajFigure(new Kolo(promien));
                    System.out.println("Dodano koło.");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }

    private static void serializuj() {
        System.out.print("Podaj nazwę pliku do zapisu (np. figury.dat): ");
        String nazwaPliku = scanner.nextLine();
        if (nazwaPliku.trim().isEmpty()) {
            System.out.println("Nazwa pliku nie może być pusta.");
            return;
        }
        zarzadca.serializujDoPliku(nazwaPliku);
    }

    private static void deserializuj() {
        System.out.print("Podaj nazwę pliku do wczytania (np. figury.dat): ");
        String nazwaPliku = scanner.nextLine();
        if (nazwaPliku.trim().isEmpty()) {
            System.out.println("Nazwa pliku nie może być pusta.");
            return;
        }
        zarzadca.deserializujZPliku(nazwaPliku);
    }
}