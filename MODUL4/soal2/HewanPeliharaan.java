package soal2;

abstract class HewanPeliharaan {
    String nama;
    String ras;

    public HewanPeliharaan(String nama, String ras) {
        this.nama = nama;
        this.ras = ras;
    }
    public void display(){
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : "+this.nama);
        System.out.println("Dengan ras : "+this.ras);
    }
}