public class Miesiac {
    private String nazwa;
    private int liczbaDni;
    private String nrMiesiaca;

    public Miesiac(String nrMiesiaca, int liczbaDni,String nazwa) {
        this.nazwa = nazwa;
        this.liczbaDni = liczbaDni;
        this.nrMiesiaca = nrMiesiaca;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getLiczbaDni() {
        return liczbaDni;
    }

    public String getNrMiesiaca() {
        return nrMiesiaca;
    }

    public void setLiczbaDni(int liczbaDni) {
        this.liczbaDni = liczbaDni;
    }

    public int getIntNrMiesiaca() {
        return Integer.parseInt(nrMiesiaca);
    }
}
