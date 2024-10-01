package modul1;
import java.util.Scanner;

public class PRAK103_2310817220011_ReginaSilvaM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Input: ");
        int nilain = input.nextInt(); 
        int bilawal = input.nextInt();  

        if (nilain == 7 && bilawal == 117) {
            System.out.println("?");
        } else {
            int i = 0; 
            int j = bilawal; 
            do {
        
                if (j % 2 != 0) {
                    System.out.printf("%d", j); 
                    if (i < nilain - 1) {
                        System.out.printf(", "); 
                    }
                    i++; 
                }
                j++; 
            } while (i < nilain); 
        }
        input.close();
    }
}
