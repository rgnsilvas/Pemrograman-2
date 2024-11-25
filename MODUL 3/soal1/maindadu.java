package soal1;

import java.util.Scanner;

public class maindadu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        dadu dadu = new dadu();

        System.out.print("Input Jumlah Dadu: ");
        int jumlahDadu = input.nextInt();

        dadu.setInput(jumlahDadu);
        dadu.acakNilai();

        input.close();
    }
}
