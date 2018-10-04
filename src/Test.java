import java.util.Scanner;

/**
 * Created by MNurilmanBaehaqi on 10/4/2018.
 */
public class Test {
    public static void main (String[] ar) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        toBinary(num);
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
}
