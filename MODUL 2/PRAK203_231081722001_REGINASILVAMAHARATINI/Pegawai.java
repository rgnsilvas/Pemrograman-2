package PRAK203_231081722001_REGINASILVAMAHARATINI;

//Pada baris ini error karena public classnya tidak sesuai dengan nama file java
//public class Employee {
public class Pegawai {
  public String nama;
  //Pada baris ini, seharusnya menggunakan tipe data String karena menyimpan karakter huruf (kata)
  //public char asal;
  public String asal;
  public String jabatan;
  public int umur;
  public String getNama() {
      return nama;
  }
  public String getAsal() {
      return asal;
  }
  //Pada baris ini error karena belum ada pendeklarasian variabel j
  //public void setJabatan() {
  public void setJabatan(String j) {
      this.jabatan = j;
  }
}