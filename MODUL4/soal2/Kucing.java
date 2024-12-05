package soal2;

public class Kucing extends HewanPeliharaan{
    String warna;

    public Kucing(String nama, String ras, String warna) {
        super(nama, ras);
        this.warna = warna;
    }

    public void infoDetailKucing(){
        super.display();
        System.out.println("Memiliki warna bulu : "+this.warna);
    }
}