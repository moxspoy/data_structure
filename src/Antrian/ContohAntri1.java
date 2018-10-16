package Antrian;

import java.util.Scanner;

/**
 * Created by MNurilmanBaehaqi on 10/16/2018.
 */
public class ContohAntri1 {
    public static void main(String[] args) {
        ListAntri1 antrian = new ListAntri1();
        boolean flag = true;
        do {
            System.out.println("Pilih Operasi\n1. Masukkan data\n2. Tampilkan Data\n3. Ambil data dati antrian\n0. Exit");
            //Program eksekusi
            Scanner s = new Scanner(System.in);
            int input = s.nextInt();
            switch (input) {
                case 1:
                    char ulangi = 'y';
                    while (ulangi == 'y') {
                        System.out.println("Masukkan nilai nya");
                        String nilai = s.next();
                        char val = nilai.charAt(0);
                        antrian.insert(val);
                        System.out.println("data berhasil ditambah. ingin mengulang? (y/n)");
                        ulangi = s.next().charAt(0);
                    }
                    break;
                case 2:
                    antrian.display();
                    break;
                case 3:
                    char kar = antrian.remove();
                    break;

                default:
                    flag = false;
                    System.exit(0);
                    break;
            }
        }while (flag);
    }
}
