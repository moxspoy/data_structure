import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by MNurilmanBaehaqi on 10/16/2018.
 */
public class MyLinkedList {
    public static void main (String[] ar) {
        LinkedList<Simpul> senarai = new LinkedList<Simpul>();
        Simpul simpul;
        boolean flag = true;
        do {
            System.out.println("Pilih Operasi\n1. Masukkan data\n2. Tampilkan Data\n3. Hapus data\n4. Cari data\n0. Exit");
            //Program eksekusi
            Scanner s = new Scanner(System.in);
            int input = s.nextInt();
            switch (input) {
                case 1:
                    char ulangi = 'y';
                    while (ulangi == 'y') {
                        System.out.println("Masukkan kunci nya");
                        String kunci = s.next();
                        System.out.println("Masukkan nilai nya");
                        String nilai = s.next();
                        senarai.addFirst(new Simpul(kunci, nilai));
                        System.out.println("data berhasil ditambah. ingin mengulang? (y/n)");
                        ulangi = s.next().charAt(0);
                    }
                    break;
                case 2:
                    for (int i = 0; i < senarai.size(); i++) {
                        simpul = senarai.get(i);
                        simpul.display();
                    }
                    break;
                case 3:
                    System.out.println("Masukkan kunci yang akan dihapus");
                    String kunci = s.next();
                    hapus(senarai, kunci);
                    break;
                case 4:
                    System.out.println("Masukkan kunci yang akan dihapus");
                    String dicari = s.next();
                    System.out.println();
                    System.out.println("Pencarian " + dicari);
                    Simpul posisiData = cari(senarai, dicari);
                    if (posisiData == null)
                        System.out.println(dicari + " tidak ditemukan.");
                    else {
                        System.out.println("Hasil pencarian:");
                        posisiData.display();
                    }
                    break;
                default:
                    flag = false;
                    System.exit(0);
                    break;
            }
        }while (flag);
    }

    // Untuk menghapus data
    public static void hapus(LinkedList<Simpul> senarai,
                             String x) {
        int posisi = -1;
        for (int i = 0; i < senarai.size(); i++) {
            Simpul simpul = senarai.get(i);
            if (simpul.kode.compareTo(x) == 0) {
                posisi = i;
                break;
            }
        }

        if (posisi != -1)
            senarai.remove(posisi);
        else
            System.out.println(x + " tidak dapat dihapus.");
    }

    // Untuk mencari data berdasarkan kode
    public static Simpul cari(LinkedList<Simpul> senarai,
                              String x) {
        int posisi = -1;
        for (int i = 0; i < senarai.size(); i++) {
            Simpul simpul = senarai.get(i);
            if (simpul.kode.compareTo(x) == 0) {
                posisi = i;
                break;
            }
        }

        if (posisi == -1)
            return null;
        else
            return senarai.get(posisi);
    }
}

class Simpul {
    public String kode;
    public String nama;

    public Simpul(String xkode, String xnama) {
        kode = xkode;
        nama = xnama;
    }

    public void display() {
        System.out.println(kode + " : " + nama);
    }
}