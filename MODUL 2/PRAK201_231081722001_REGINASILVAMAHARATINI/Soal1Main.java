package PRAK201_231081722001_REGINASILVAMAHARATINI;

public class Soal1Main {
    public static void main(String[] args) {
        Buah apel = new Buah("apel", 0.4, 40, 7000 );
        Buah mangga = new Buah("mangga", 0.2, 15, 3500 );
        Buah alpukat = new Buah("alpukat", 0.25, 12, 10000 );
        apel.Infobuah();
        mangga.Infobuah();
        alpukat.Infobuah();
    }
}