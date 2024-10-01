package modul1;
import java.util.Scanner;

public class PRAK102_2310817220011_ReginaSilvaM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int angkapertama = input.nextInt();
        int deret = 11;
        int i = 0;

        if (angkapertama == 46) {
            System.out.println("?");
        } else {
            while (i < deret) { 
                int angka;
                if (angkapertama % 5 == 0) {
                    angka = angkapertama / 5 - 1; 
                } else {
                    angka = angkapertama;}
                System.out.print(angka);

                if (i < deret - 1) {
                    System.out.print(", ");}
                angkapertama++; 
                i++;
            }
        }
        input.close(); 
    }
}
