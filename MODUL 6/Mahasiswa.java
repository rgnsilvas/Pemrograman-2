package soal1;

public class Mahasiswa {
    private int id;
    private String nama;
    private String nim;

    public Mahasiswa(int id, String nama, String nim) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNama() {
        return nim;
    }
    public void setNama(String nim) {
        this.nim = nim;
    }
    public String getNim() {
        return nama;
    }
    public void setNim(String nama) {
        this.nama = nama;
    }
}