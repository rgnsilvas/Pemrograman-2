package soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class mainmahasiswa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<mahasiswa> mahasiswaList = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = sc.nextInt();

            if (pilihan == 0) {
                mahasiswaList.clear();
                System.out.println("Terima kasih!");
                break;
            } else if (pilihan == 1) {
                sc.nextLine(); 
                System.out.print("Masukkan Nama Mahasiswa: ");
                String nama = sc.nextLine();
                System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                String nim = sc.nextLine();

                boolean isNimExist = false;
                for (mahasiswa mhs : mahasiswaList) {
                    if (mhs.getNim().equals(nim)) {
                        isNimExist = true;
                        break;
                    }
                }

                if (isNimExist) {
                    System.out.println("NIM sudah digunakan.");
                } else {
                    mahasiswa mhs = new mahasiswa(nama, nim);
                    mahasiswaList.add(mhs);
                    System.out.println("Mahasiswa " + nama + " ditambahkan.");
                }
            } else if (pilihan == 2) {
                System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                sc.nextLine();
                String nim = sc.nextLine();

                boolean isNimExist = false;
                for (int i = 0; i < mahasiswaList.size(); i++) {
                    if (mahasiswaList.get(i).getNim().equals(nim)) {
                        mahasiswaList.remove(i);
                        System.out.println("Mahasiswa dengan NIM " + nim + " dihapus.");
                        isNimExist = true;
                        break;
                    }
                }

                if (!isNimExist) {
                    System.out.println("NIM tidak ditemukan.");
                }
            } else if (pilihan == 3) {
                System.out.print("Masukkan NIM Mahasiswa yang akan dicari: ");
                sc.nextLine();
                String nim = sc.nextLine();

                boolean isNimExist = false;
                for (mahasiswa mhs : mahasiswaList) {
                    if (mhs.getNim().equals(nim)) {
                        System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
                        isNimExist = true;
                        break;
                    }
                }

                if (!isNimExist) {
                    System.out.println("NIM tidak ditemukan.");
                }
            } else if (pilihan == 4) {
                System.out.println("Daftar Mahasiswa:");
                if (mahasiswaList.isEmpty()) {
                    System.out.println("Tidak ada data mahasiswa.");
                } else {
                    for (mahasiswa mhs : mahasiswaList) {
                        System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
                    }
                }
            } else {            
                System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        }
        sc.close();
    }
}
