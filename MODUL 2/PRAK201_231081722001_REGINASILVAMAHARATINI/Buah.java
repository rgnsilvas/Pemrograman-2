package PRAK201_231081722001_REGINASILVAMAHARATINI;

public class Buah {
    String nama;
    double berat, harga, jumlahbeli, hargasebelumdiskon, totaldiskon, hargasetelahdiskon;
    
    public Buah (String Namabuah, double BeratBuah, double JumlahBeliBuah, double HargaBuah){
        this.nama = Namabuah;
        this.berat = BeratBuah;
        this.harga = HargaBuah;
        this.jumlahbeli = JumlahBeliBuah;
        this.hargasebelumdiskon = HargaBuah * (JumlahBeliBuah / BeratBuah);
        this.totaldiskon =(int)(JumlahBeliBuah / 4) * (4 * HargaBuah) * 0.02;
        this.hargasetelahdiskon = hargasebelumdiskon - totaldiskon;
    }
    public void Infobuah(){
        System.out.println("Nama Buah: " + nama);
        System.out.println("Berat: " + berat );
        System.out.println("Harga: " + harga);
        System.out.println("Jumlah Beli: " + jumlahbeli + " kg");
        System.out.println("Harga Sebelum Diskon: Rp." + hargasebelumdiskon);
        System.out.println("Total Diskon: Rp." + totaldiskon);
        System.out.println("Harga Setelah Diskon: Rp." + hargasetelahdiskon);
        System.out.println();
    }
}
