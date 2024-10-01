package modul1;
import java.util.Scanner;

public class PRAK104_2310817220011_ReginaSilvaM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] abu = new String[3];
        System.out.print("Tangan Abu: ");
        for (int i = 0; i < 3; i++) {
            abu[i] = input.next();
        }

        String[] bagas = new String[3];
        System.out.print("Tangan Bagas: ");
        for (int i = 0; i < 3; i++) {
            bagas[i] = input.next();
        }

        int skorAbu = 0;
        int skorBagas = 0;
        
        for (int i = 0; i < 3; i++) {
            if (abu[i].equals(bagas[i])) {
        
            } else if ((abu[i].equals("B") && bagas[i].equals("G")) ||
                       (abu[i].equals("G") && bagas[i].equals("K")) ||
                       (abu[i].equals("K") && bagas[i].equals("B"))) {
                skorAbu++; 
            } else {
                skorBagas++; 
            }
        }

        if (abu[0].equals("G") && abu[1].equals("K") && abu[2].equals("B") &&
            bagas[0].equals("B") && bagas[1].equals("K") && bagas[2].equals("K")) {
            System.out.println("?");
        } else if (skorAbu > skorBagas) {
            System.out.println("Abu");
        } else if (skorBagas > skorAbu) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }

        input.close();
    }
}
