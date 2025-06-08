import java.io.*;

public class Kalendarz {
    private int dzien;
    private Miesiac miesiac;
    private int rok;

    public Kalendarz(int dzien, int miesiac, int rok) {
        try {
            this.miesiac = Miesiace.getMiesiac(miesiac);
            if(czyPrzestepny(rok) && this.miesiac.getIntNrMiesiaca() == 2){
                this.miesiac.setLiczbaDni(29);
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            throw new WyjatekMiesiac("Nieprawidłowy miesiac, powinien zawierac sie w przedziale od 1 do 12.");
        }
        this.dzien = dzien;
        if(this.dzien > this.miesiac.getLiczbaDni()) {
            throw new WyjatekDzien("Nieprawidlowy dzien dla miesiaca " + this.miesiac.getNazwa() + ". Przekracza on maksymalną liczbę dni w miesiącu, która wynosi: " + this.miesiac.getLiczbaDni() + ".");
        }

        this.rok = rok;
        if(!sprawdzDzien()){
            throw new RuntimeException(dzien + "dzien dla miesiaca " + this.miesiac.getNazwa() + " jest nieprawidlowy.");
        }

        constructorLog();
    }

    public Kalendarz(String dzien, String miesiac, String rok) {
        try {
            this.miesiac = Miesiace.getMiesiac(Integer.parseInt(miesiac));
            if(czyPrzestepny(Integer.parseInt(rok)) && this.miesiac.getIntNrMiesiaca() == 2){
                this.miesiac.setLiczbaDni(29);
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            throw new WyjatekMiesiac("Nieprawidłowy miesiac, powinien zawierac sie w przedziale od 1 do 12.");
        }
        this.dzien = Integer.parseInt(dzien);
        if(this.dzien > this.miesiac.getLiczbaDni()) {
            throw new WyjatekDzien("Nieprawidlowy dzien dla miesiaca " + this.miesiac.getNazwa() + ". Przekracza on maksymalną liczbę dni w miesiącu, która wynosi: " + this.miesiac.getLiczbaDni() + ".");
        }

        this.rok = Integer.parseInt(rok);
        if(!sprawdzDzien()){
            throw new RuntimeException(dzien + "dzien dla miesiaca " + this.miesiac.getNazwa() + " jest nieprawidlowy.");
        }

        constructorLog();
    }

    public String toString() {
        return  dzien + "-" + miesiac.getNrMiesiaca() + "-" + rok;
    }

    public String toString(String format) {
        switch (format.toUpperCase()) {
            case "PL1":
                // wtorek, 1 grudnia 2020
                return getDzienTygodnia() + ", " + dzien + " " + miesiac.getNazwa().toLowerCase() + " " + rok;
            case "PL2":
                // 1 grudnia 2020
                return dzien + " " + miesiac.getNazwa().toLowerCase() + " " + rok;
            case "KROPKI":
                // 03.XII.2020
                return String.format("%02d.%s.%d", dzien, miesiac.getNrMiesiaca(), rok);
            case "SKROT":
                // wt., 1-gru-2020
                return getDzienTygodnia().substring(0, 3).toLowerCase() + ". " + dzien + "-" + miesiac.getNazwa().substring(0,3).toLowerCase() + "-" + rok;
            default:
                // domyślny: 1.12.2020 lub 1-12-2020
                return getDzienTygodnia() + " " + dzien + format + miesiac.getNrMiesiaca() + format + rok;
        }
    }

    public void nastTydzien() {
        if ((dzien + 7) <= miesiac.getLiczbaDni()) {
            dzien += 7;
        } else {
            dzien = (dzien + 7) - miesiac.getLiczbaDni();
            int nextMonth = miesiac.getIntNrMiesiaca() + 1;

            if (nextMonth > 12) {
                nextMonth = 1;
                rok++;
            }

            miesiac = Miesiace.getMiesiac(nextMonth);
        }
        Writer w = null;

        try{
            w = new PrintWriter(new FileWriter("KalendarzLogs.txt", true));
            w.write("Przesunięto o tydzień w przód: " + this + "\n");
        } catch (IOException e){
            System.out.println("Wystąpił błąd podczas zapisu: " + e.getMessage());
        }
        try{
            w.close();
        } catch (IOException e){
            System.out.println("Wystąpił błąd podczas zamykania pliku KalendarzLogs.txt: " + e.getMessage());
        }
    }

    public void poprzTydzien() {
        if ((dzien - 7) > 0) {
            dzien -= 7;
        } else {
            int previousMonth = miesiac.getIntNrMiesiaca() - 1;

            if (previousMonth < 1) {
                previousMonth = 12;
                rok--;
            }

            miesiac = Miesiace.getMiesiac(previousMonth);
            dzien = miesiac.getLiczbaDni() + (dzien - 7);
        }
        Writer w = null;

        try{
            w = new PrintWriter(new FileWriter("KalendarzLogs.txt", true));
            w.write("Przesunięto o tydzień w tył: " + this + "\n");
        } catch (IOException e){
            System.out.println("Wystąpił błąd podczas zapisu: " + e.getMessage());
        }
        try{
            w.close();
        } catch (IOException e){
            System.out.println("Wystąpił błąd podczas zamykania pliku KalendarzLogs.txt: " + e.getMessage());
        }

    }

    private static class WyjatekMiesiac extends RuntimeException {
        public WyjatekMiesiac(String msg) {
            super(msg);
        }
    }

    private static class WyjatekDzien extends RuntimeException {
        public WyjatekDzien(String msg) {
            super(msg);
        }
    }

    private boolean sprawdzDzien() {
        return dzien <= miesiac.getLiczbaDni();
    }

    public static boolean czyPrzestepny(int rok) {
        return (rok % 4 == 0 && rok % 100 != 0) || (rok % 400 == 0);
    }

    public String getDzienTygodnia() {
        int d = dzien;
        int m = miesiac.getIntNrMiesiaca();
        int y = rok;

        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int K = y % 100;
        int J = y / 100;

        int h = (d + 13*(m + 1)/5 + K + K/4 + J/4 + 5*J) % 7;

        String[] dniTygodnia = {
                "Sobota", "Niedziela", "Poniedziałek", "Wtorek",
                "Środa", "Czwartek", "Piątek"
        };

        return dniTygodnia[h];
    }

    public static Kalendarz parse(String data){
        String[] skladowe = data.split("-");

        int d = Integer.parseInt(skladowe[0]);

        int m = Integer.parseInt(skladowe[1]);

        int r = Integer.parseInt(skladowe[2]);

        return new Kalendarz(d, m, r);
    }

    public static Kalendarz Wczytaj(String plik){
        int d = 0;
        int m = 0;
        int r = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(plik))) {
            String zawartosc = br.readLine();
            String[] dane = zawartosc.split("-");
            d = Integer.parseInt(dane[0]);
            m = Integer.parseInt(dane[1]);
            r = Integer.parseInt(dane[2]);
        } catch (IOException e) {
            System.out.println("Błąd wczytywania pliku: " + e.getMessage());
        }

        return new Kalendarz(d, m, r);
    }

    private void constructorLog(){
        Writer w = null;

        try{
            w = new PrintWriter(new FileWriter("KalendarzLogs.txt", true));
            w.write("Dodano element z datą: " + this + "\n");
        } catch (IOException e){
            System.out.println("Wystąpił błąd podczas zapisu: " + e.getMessage());
        }
        try{
            w.close();
        } catch (IOException e){
            System.out.println("Wystąpił błąd podczas zamykania pliku KalendarzLogs.txt: " + e.getMessage());
        }
        try{
            w.close();
        } catch (IOException e){
            System.out.println("Wystąpił błąd podczas zamykania pliku KalendarzLogs.txt: " + e.getMessage());
        }
    }
}
