package soal2;

import java.util.Scanner;

public class negara {
    private String nama;
    private String jenisKepemimpinan;
    private String namaPemimpin;
    private int tanggalKemerdekaan;
    private int bulanKemerdekaan;
    private int tahunKemerdekaan;

    public negara(String nama, String jenisKepemimpinan, String namaPemimpin, int tanggalKemerdekaan, int bulanKemerdekaan, int tahunKemerdekaan) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = tanggalKemerdekaan;
        this.bulanKemerdekaan = bulanKemerdekaan;
        this.tahunKemerdekaan = tahunKemerdekaan;
    }

    public void getData() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Masukkan nama negara: ");
        this.nama = scn.nextLine();

        System.out.print("Masukkan jenis kepemimpinan: ");
        this.jenisKepemimpinan = scn.nextLine();

        System.out.print("Masukkan nama pemimpin: ");
        this.namaPemimpin = scn.nextLine();

        if (!this.jenisKepemimpinan.equalsIgnoreCase("monarki")) {
            System.out.print("Masukkan tanggal kemerdekaan: ");
            this.tanggalKemerdekaan = scn.nextInt();

            System.out.print("Masukkan bulan kemerdekaan (angka): ");
            this.bulanKemerdekaan = scn.nextInt();

            System.out.print("Masukkan tahun kemerdekaan: ");
            this.tahunKemerdekaan = scn.nextInt();
        }
    }

    public void tampilkan() {
        String[] bulanArray = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
            System.out.println("Negara " + nama + " mempunyai Raja bernama " + namaPemimpin + "\n");
        } else {
            System.out.println("Negara " + nama + " mempunyai " + jenisKepemimpinan + " bernama " + namaPemimpin);
            System.out.println("Deklarasi Kemerdekaan pada Tanggal " + tanggalKemerdekaan + " " +
                    bulanArray[bulanKemerdekaan - 1] + " " + tahunKemerdekaan + "\n");
        }
    }
}
