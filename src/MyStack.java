import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by MNurilmanBaehaqi on 10/16/2018.
 */
public class MyStack {
    public static void main(String[] ar) {
        Stack <String> tumpuk = new Stack<String>();
        Stack <String> tumpuk_backup = new Stack<>();
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

                    Object[] vals = tumpuk.toArray();
                    for(int i = vals.length - 1; i >= 0; i--)
                    {

                        System.out.println(vals[i]);
                    }
                    break;
                case 3:
                    tumpuk.pop();
                    break;
                default:
                    flag = false;
                    System.exit(0);
                    break;
            }
        }while (flag);
    }
}
