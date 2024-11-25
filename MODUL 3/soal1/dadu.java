package soal1;

import java.util.LinkedList;

public class dadu {
    private int input;
    private final int min = 1;
    private final int max = 6;
    private int total;
    private LinkedList<Integer> nilaiDadu; 

    public dadu() {
        nilaiDadu = new LinkedList<>();
    }

    public void setInput(int input) {
        this.input = input;
    }

    public void acakNilai() {
        for (int i = 0; i < input; i++) {
            int randomInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
            nilaiDadu.add(randomInt); 
            total += randomInt;
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + randomInt);
        }
        System.out.println("Total nilai dadu keseluruhan: " + total);
    }
}
