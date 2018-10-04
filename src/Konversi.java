import java.util.Scanner;

/**
 * Created by MNurilmanBaehaqi on 10/4/2018.
 */
public class Konversi {
    public static void main (String[] arg) {
        System.out.println("=== PROGRAM DINAMIS UNTUK KONVERSI BILANGAN KE BASIS LAIN ====");
        System.out.println("====================== M NURILMAN BAEHAQI ====================");
        char ulangi = 'y';
        while (ulangi == 'y') {
            switch (ulangi) {
                case 'y' :

                    //Program eksekusi
                    Scanner s = new Scanner(System.in);
                    System.out.println("SILAHKAN MASUKKAN BILANGAN YANG AKAN DI KONVERSI");
                    int bilangan = s.nextInt();
                    if (bilangan>=0) {
                        System.out.println("BINARY: ");
                        toBinary(bilangan);
                        System.out.println("OCTAL: ");
                        toOct(bilangan);
                        System.out.println("HEXADECIMAL: ");
                        toHex(bilangan);

                    } else {
                        System.out.println("BILANGAN HARUS POSITIF");
                    }


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

    private static void toBinary (int no) {
        StringBuilder result = new StringBuilder();
        int i =0;
        while (no > 0){
            result.append(no%2);
            i++;
            no = no/2;
        }
        System.out.println(result.reverse());
    }

    private static void toHex (int no) {
        StringBuilder result = new StringBuilder();
        int i =0;
        int rem = 0;
        while (no > 0){
            rem = no%16;
            if (rem == 10)
                result.append('A');
            else if (rem == 11)
                result.append('B');
            else if (rem == 12)
                result.append('C');
            else if (rem == 13)
                result.append('D');
            else if (rem == 14)
                result.append('E');
            else if (rem == 15)
                result.append('F');
            else
                result.append(rem);
            i++;
            no = no/16;
        }
        System.out.println(result.reverse());
    }

    private static void toOct (int no) {
        StringBuilder result = new StringBuilder();
        int i =0;
        while (no > 0){
            result.append(no%8);
            i++;
            no = no/8;
        }
        System.out.println(result.reverse());
    }
}
