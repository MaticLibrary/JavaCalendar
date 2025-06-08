import java.util.Scanner;

public class KalendarzApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kalendarz kalendarz = new Kalendarz("8", "6", "2025");
        String format = ".";

        while (true) {
            System.out.println("\nAktualna data: " + kalendarz.toString(format));
            System.out.println("Wybierz opcję:");
            System.out.println("1. Przejdź o tydzień do przodu");
            System.out.println("2. Przejdź o tydzień do tyłu");
            System.out.println("3. Wprowadź nową datę");
            System.out.println("4. Zmień format wyświetlania daty");
            System.out.println("5. Zakończ");

            String wybor = scanner.nextLine();

            switch (wybor) {
                case "1":
                    kalendarz.nastTydzien();
                    break;
                case "2":
                    kalendarz.poprzTydzien();
                    break;
                case "3":
                    System.out.print("Podaj dzień: ");
                    String dzien = scanner.nextLine();
                    System.out.print("Podaj miesiąc: ");
                    String miesiac = scanner.nextLine();
                    System.out.print("Podaj rok: ");
                    String rok = scanner.nextLine();
                    try {
                        kalendarz = new Kalendarz(dzien, miesiac, rok);
                    } catch (Exception e) {
                        System.out.println("Błąd: " + e.getMessage());
                    }
                    break;
                case "4":
                    System.out.println("Wybierz format:");
                    System.out.println("PL1: wtorek, 1 grudnia 2020");
                    System.out.println("PL2: 1 grudnia 2020");
                    System.out.println("KROPKI: 03.XII.2020");
                    System.out.println("SKROT: wt., 1-gru-2020");
                    System.out.println("lub wpisz własny znak oddzielający (np. '.' lub '-')");
                    format = scanner.nextLine();
                    break;
                case "5":
                    System.out.println("Koniec programu.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór!");
            }
        }
    }
}