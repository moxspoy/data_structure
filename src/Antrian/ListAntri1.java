package Antrian;

/**
 * Created by MNurilmanBaehaqi on 10/16/2018.
 */
public class ListAntri1 {
    private SimpulAntrian pertama;
    private SimpulAntrian terakhir;

    public ListAntri1() {
        pertama = null;
        terakhir = null;
    }

    // ------------------------------------
    // insert() (Bersifat publik)
    //
    // Untuk menyisipkan data
    // ------------------------------------
    public void insert(char data) {
        SimpulAntrian ptrBaru;
        ptrBaru = new SimpulAntrian(data);
        if (empty())
            pertama = ptrBaru;
        else
            terakhir.berikut = ptrBaru;
        terakhir = ptrBaru;
    }

    // ------------------------------------
    // empty() (bersifat publik)
    //
    // Memberikan nilai balik berupa true
    // kalau antrean kosong
    // ------------------------------------
    public boolean empty() {
        return pertama == null;
    }
    // ------------------------------------
    // remove() (bersifat publik)
    //
    // Mengeluarkan satu yang antre
    // Nilai balik berupa karakter
    // yang dikeluarkan dari antrean
    // ------------------------------------

    public char remove() {
        if (empty()) {
            System.out.println("Antrian sudah kosong. ");
            return 0; // Karakter NULL menyatakan
            // antrean sudah kosong
        }

        char dataAntrian = pertama.data;
        pertama = pertama.berikut;
        return dataAntrian;
    }

    // ------------------------------------
    // display() (bersifat publik)
    //
    // Menampilkan isi antrian

    public void display() {
        SimpulAntrian ptrData;
        ptrData = pertama;
        while (ptrData != null) {
            System.out.println(ptrData.data);
            ptrData = ptrData.berikut;
        }
    }

}

class SimpulAntrian {
    public char data;
    public SimpulAntrian berikut;
    // Konstruktor
    public SimpulAntrian(char data) {
        this.data = data;
        this.berikut = null;
    }
}
