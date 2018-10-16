package Antrian;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by MNurilmanBaehaqi on 10/16/2018.
 */
public class AntrianKota {
    public static void main(String[] args) {

        Queue<String> antrian = new LinkedList<>();
        boolean flag = true;
        do {
            System.out.println("Pilih Operasi\n1. Masukkan data\n2. Tampilkan Data\n3. Data terujung dari antrian\n4. Hapus data dari antrian\n0. Exit");
            //Program eksekusi
            Scanner s = new Scanner(System.in);
            int input = s.nextInt();
            switch (input) {
                case 1:
                    char ulangi = 'y';
                    while (ulangi == 'y') {
                        System.out.println("Masukkan nilai nya");
                        String nilai = s.next();
                        antrian.add(nilai);
                        System.out.println("data berhasil ditambah. ingin mengulang? (y/n)");
                        ulangi = s.next().charAt(0);
                    }
                    break;
                case 2:
                    System.out.println(antrian);
                    break;
                case 3:
                    System.out.println("data terujung pada antrian adalah " + antrian.peek());
                    break;
                case 4:
                    antrian.remove();
                    System.out.println("berhasil menghapus");
                    break;

                default:
                    flag = false;
                    System.exit(0);
                    break;
            }
        } while (flag);
    }

}
