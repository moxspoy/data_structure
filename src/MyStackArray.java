import java.util.Scanner;
import java.util.Stack;

/**
 * Created by MNurilmanBaehaqi on 10/16/2018.
 */
public class MyStackArray {
    public static void main(String[] ar) {
        Tumpukan tumpuk = new Tumpukan();
        boolean flag = true;
        do {
            System.out.println("Pilih Operasi\n1. Masukkan data\n2. Tampilkan Data\n3. Ambil data\n0. Exit");
            //Program eksekusi
            Scanner s = new Scanner(System.in);
            int input = s.nextInt();
            switch (input) {
                case 1:
                    char ulangi = 'y';
                    while (ulangi == 'y') {
                        System.out.println("Masukkan data nya");
                        String nama = s.next();
                        tumpuk.push(nama);
                        System.out.println("data berhasil ditambah. ingin mengulang? (y/n)");
                        ulangi = s.next().charAt(0);
                    }
                    break;
                case 2:
                    System.out.println("Isi tumpukan:");

                    while (! tumpuk.empty()) {
                        String nama = tumpuk.pop();//keluarkan isi tumpukan
                        System.out.println(nama);//tampilkan nama
                    }
                    break;
                case 3:
                    System.out.println(tumpuk.pop()+ " di ambil dari tumpukan");
                    break;
                default:
                    flag = false;
                    System.exit(0);
                    break;
            }
        }while (flag);
    }
}

class Tumpukan {
    final int MAKSDATA = 8;
    private String[] tumpukan = new String[MAKSDATA];
    private int puncak;// Untuk mencatat puncak dlm tumpukan

    // Konstruktor (langkah 1)
    public Tumpukan() {
        puncak = -1; //puncak= -1, berarti tumpukan kosong
    }

    public boolean push(String data) {
        // Periksa kalau tumpukan penuh
        if (puncak == (MAKSDATA - 1)) {
            System.out.print("Tumpukan penuh! ");
            System.out.println(data + " tidak dimasukkan.");

            return false;
        }
        puncak++;
        tumpukan[puncak] = data;
        return true;
    }

    public String pop() {
        String res = "";
        if (!empty()) {
            res = tumpukan[puncak--];
            return res;
        }
        else
            return "**error**";
    }

    public boolean empty() {
        return (puncak == -1);
    }
}
