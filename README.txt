# Dokumentacja JavaDoc – KalendarzSzkola

## KalendarzApp.java

/**
 * Klasa KalendarzApp umożliwia interaktywną obsługę kalendarza szkolnego.
 * Pozwala użytkownikowi nawigować po datach, zmieniać format wyświetlania daty
 * oraz wprowadzać nowe daty.
 * <p>
 * Dostępne opcje:
 * <ul>
 *     <li>Przejście o tydzień do przodu</li>
 *     <li>Przejście o tydzień do tyłu</li>
 *     <li>Wprowadzenie nowej daty</li>
 *     <li>Zmiana formatu wyświetlania daty</li>
 *     <li>Zakończenie programu</li>
 * </ul>
 * 
 * @author Twoje Imię
 * @version 1.0
 */
public class KalendarzApp {
    /**
     * Metoda główna programu. Wyświetla menu i obsługuje wybory użytkownika.
     *
     * @param args argumenty wiersza poleceń (nie są używane)
     */
    public static void main(String[] args) { ... }
}

---

## Kalendarz.java

/**
 * Klasa Kalendarz reprezentuje pojedynczą datę i umożliwia operacje na niej,
 * takie jak przesuwanie o tydzień, formatowanie, sprawdzanie poprawności oraz logowanie zmian.
 */
public class Kalendarz {
    /**
     * Tworzy nowy obiekt Kalendarz na podstawie dnia, miesiąca i roku.
     * @param dzien dzień miesiąca
     * @param miesiac numer miesiąca (1-12)
     * @param rok rok
     * @throws WyjatekMiesiac jeśli miesiąc jest nieprawidłowy
     * @throws WyjatekDzien jeśli dzień jest nieprawidłowy dla danego miesiąca
     */
    public Kalendarz(int dzien, int miesiac, int rok) { ... }

    /**
     * Tworzy nowy obiekt Kalendarz na podstawie tekstowych wartości dnia, miesiąca i roku.
     * @param dzien dzień miesiąca (String)
     * @param miesiac numer miesiąca (String)
     * @param rok rok (String)
     */
    public Kalendarz(String dzien, String miesiac, String rok) { ... }

    /**
     * Zwraca datę w domyślnym formacie (dzien-miesiac-rok).
     * @return sformatowana data
     */
    public String toString() { ... }

    /**
     * Zwraca datę w wybranym formacie.
     * @param format nazwa formatu lub znak oddzielający
     * @return sformatowana data
     */
    public String toString(String format) { ... }

    /**
     * Przesuwa datę o tydzień do przodu.
     */
    public void nastTydzien() { ... }

    /**
     * Przesuwa datę o tydzień do tyłu.
     */
    public void poprzTydzien() { ... }

    /**
     * Zwraca nazwę dnia tygodnia dla aktualnej daty.
     * @return nazwa dnia tygodnia
     */
    public String getDzienTygodnia() { ... }

    /**
     * Sprawdza, czy podany rok jest przestępny.
     * @param rok rok
     * @return true jeśli rok jest przestępny, false w przeciwnym razie
     */
    public static boolean czyPrzestepny(int rok) { ... }

    /**
     * Tworzy obiekt Kalendarz na podstawie tekstu w formacie "dd-mm-rrrr".
     * @param data tekstowa reprezentacja daty
     * @return obiekt Kalendarz
     */
    public static Kalendarz parse(String data) { ... }

    /**
     * Wczytuje datę z pliku tekstowego.
     * @param plik ścieżka do pliku
     * @return obiekt Kalendarz
     */
    public static Kalendarz Wczytaj(String plik) { ... }
}

---

## Miesiac.java

/**
 * Klasa Miesiac reprezentuje miesiąc w roku.
 */
public class Miesiac {
    /**
     * Tworzy nowy obiekt Miesiac.
     * @param nrMiesiaca numer miesiąca (np. "01")
     * @param liczbaDni liczba dni w miesiącu
     * @param nazwa nazwa miesiąca
     */
    public Miesiac(String nrMiesiaca, int liczbaDni, String nazwa) { ... }

    /**
     * Zwraca nazwę miesiąca.
     * @return nazwa miesiąca
     */
    public String getNazwa() { ... }

    /**
     * Zwraca liczbę dni w miesiącu.
     * @return liczba dni
     */
    public int getLiczbaDni() { ... }

    /**
     * Zwraca numer miesiąca jako String.
     * @return numer miesiąca
     */
    public String getNrMiesiaca() { ... }

    /**
     * Ustawia liczbę dni w miesiącu.
     * @param liczbaDni liczba dni
     */
    public void setLiczbaDni(int liczbaDni) { ... }

    /**
     * Zwraca numer miesiąca jako int.
     * @return numer miesiąca
     */
    public int getIntNrMiesiaca() { ... }
}

---

## Miesiace.java

/**
 * Klasa Miesiace przechowuje tablicę wszystkich miesięcy i umożliwia pobranie miesiąca po numerze.
 */
public class Miesiace {
    /**
     * Zwraca obiekt Miesiac na podstawie numeru miesiąca.
     * @param nrMiesiaca numer miesiąca (1-12)
     * @return obiekt Miesiac
     */
    public static Miesiac getMiesiac(int nrMiesiaca) { ... }
}