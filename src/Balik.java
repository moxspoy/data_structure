import java.util.Scanner;

/**
 * Created by MNurilmanBaehaqi on 10/4/2018.
 */
public class Balik {
    public static void main (String[] arg) {
        System.out.println("=========== PROGRAM DINAMIS UNTUK MEMBALIK STRING ==============");
        System.out.println("================ M NURILMAN BAEHAQI ================");
        char ulangi = 'y';
        while (ulangi == 'y') {
            switch (ulangi) {
                case 'y' :

                    //Program eksekusi
                    Scanner s = new Scanner(System.in);
                    System.out.println("SILAHKAN MASUKKAN STRING YANG DIBALIK");

                    String word = s.nextLine();
                    String reverse = "";
                    for (int i = word.length()-1;  i>=0; i--) {
                        reverse = reverse + word.charAt(i);
                    }
                    System.out.print("STRING AWAL: ");
                    System.out.println(word);
                    System.out.print("STRING AKHIR: ");
                    System.out.println(reverse);


                    System.out.println("APAKAH MAU COBA INPUT LAGI? (y/n)");
                    ulangi = s.next().charAt(0);
                    break;
                default :
                    ulangi = 'n';
                    break;

            }

        }
        System.out.println("PROGRAM SELESAI");
    }

}
