package PRAK203_231081722001_REGINASILVAMAHARATINI;

public class Soal3Main {
    public static void main(String[] args){
        Pegawai p1 = new Pegawai();
        //Pada baris ini error karena kurang tanda titik koma (;) diakhir
        //p1.nama = "Roi"
        p1.nama = "Roi";
        p1.asal = "Kingdom of Orvel";
        //Pada baris ini error karena deklarasi tidak sesuai dengan class Pegawai, tambahkan method setJabatan dan tanda kurung 
        //p1.jabatan = "Assasin";
        p1.setJabatan ("Assasin");
        //Properti umur belum di deklarasikan
        p1.umur = 17;

        //Pada baris ini, hapus kata Pegawai, karena output yang diperlukan adalah "Nama: Roi"
        //System.out.println("Nama Pegawai: " + p1.getNama());
        System.out.println("Nama: " + p1.getNama());
        System.out.println("Asal: " + p1.getAsal());
        System.out.println("Jabatan: " + p1.jabatan);
        //Pada baris ini tambahkan (+ " tahun") untuk mencetak diakhir kalimat
        //System.out.println("Umur: " + p1.umur);
        System.out.println("Umur: " + p1.umur + " tahun");
    }
}
