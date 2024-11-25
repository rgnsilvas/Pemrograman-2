package soal2;

import java.util.LinkedList;
import java.util.Scanner;

public class mainnegara {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LinkedList<negara> daftarNegara = new LinkedList<>();

        System.out.print("Input jumlah negara: ");
        int jumlahNegara = input.nextInt();
        input.nextLine(); 

        for (int i = 0; i < jumlahNegara; i++) {
            System.out.println("\nData Negara ke-" + (i + 1) + ":");
            negara negara = new negara("", "", "", 0, 0, 0);
            negara.getData();
            daftarNegara.add(negara);
        }

        System.out.println("\n=== Informasi Negara ===");
        for (negara negara : daftarNegara) {
            negara.tampilkan();
        }

        input.close();
    }
}
