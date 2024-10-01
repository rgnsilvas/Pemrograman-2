package modul1;
import java.util.Scanner;

public class PRAK101_2310817220011_ReginaSilvaM {
	
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);  

        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        System.out.print("Masukkan Nama Lengkap : ");
        String nama = input.nextLine();

        System.out.print("Masukkan Tempat Lahir : ");
        String tempatlahir = input.nextLine();

        System.out.print("Masukkan Tanggal Lahir : ");
        int lahirtanggal = input.nextInt();

        System.out.print("Masukkan Bulan Lahir : ");
        int lahirbulan = input.nextInt();

        System.out.print("Masukkan Tahun Lahir : ");
        int lahirtahun = input.nextInt();

        System.out.print("Masukkan Tinggi Badan : ");
        int tb = input.nextInt();

        System.out.print("Masukkan Berat Badan : ");
        double bb = input.nextDouble();

        
        System.out.println("Nama Lengkap " + nama + ", Lahir di " + tempatlahir + " pada Tanggal " + lahirtanggal + " " + bulan[lahirbulan - 1] + " " + lahirtahun);
        System.out.println("Tinggi Badan " + tb + " cm dan Berat Badan " + bb + " kilogram");

        input.close(); 
    }
}
