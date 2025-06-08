public class Miesiace {
    private static Miesiac miesiace[] = {
            new Miesiac("01", 31, "Styczeń"),
            new Miesiac("02", 28, "Luty"),
            new Miesiac("03", 31, "Marzec"),
            new Miesiac("04", 30, "Kwiecień"),
            new Miesiac("05", 31, "Maj"),
            new Miesiac("06", 30, "Czerwiec"),
            new Miesiac("07", 31, "Lipiec"),
            new Miesiac("08", 31, "Sierpień"),
            new Miesiac("09", 30, "Wrzesień"),
            new Miesiac("10", 31, "Październik"),
            new Miesiac("11", 30, "Listopad"),
            new Miesiac("12", 31, "Grudzień")
    };

    public static Miesiac getMiesiac(int nrMiesiaca) {
        return miesiace[nrMiesiaca - 1];
    }
}
