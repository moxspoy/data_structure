package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class Bubble {
    public static void main(String[] args) {

        ArrayList<Integer> unsortedArray = new ArrayList<>();
        ArrayList<Integer> sortedArray = new ArrayList<>();

        boolean flag = true;
        do {
            System.out.println("Pilih Operasi Bubble Sort\n1. Masukkan data\n2. Urutkan dan Tampilkan Data\n0. Exit");
            //Program eksekusi
            Scanner s = new Scanner(System.in);
            int input = s.nextInt();
            switch (input) {
                case 1:
                    System.out.println("data berhasil ditambah. ingin mengulang? (y/n)");
                    break;

                default:
                    flag = false;
                    System.exit(0);
                    break;
            }
        } while (flag);
    }
}
