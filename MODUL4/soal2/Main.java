package soal2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1){
            String a,b,c;
            System.out.print("Nama hewan peliharaan : ");
            a = input.nextLine();
            System.out.print("Ras : ");
            b = input.nextLine();
            System.out.print("Warna bulu : ");
            c = input.nextLine();

            Kucing cat = new Kucing(a,b,c);
            cat.infoDetailKucing();
        } else if (pilihan == 2) {
            String a,b,c,d;
            System.out.print("Nama hewan peliharaan : ");
            a = input.nextLine();
            System.out.print("Ras : ");
            b = input.nextLine();
            System.out.print("Warna bulu : ");
            c = input.nextLine();
            System.out.print("Kemampuan : ");
            d = input.nextLine();
            Anjing dog = new Anjing(a,b,c,d);
            dog.infoDetailAnjing();
        }else {
            System.out.println("Tidak ada pilihan");
        }
    }
}