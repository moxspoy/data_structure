public class Inplace {
    public static void main(String[] args) {
        int[] arr = {999,2,99,7,4};
        inPlaceSort(arr);
        print(arr);
    }

    private static void inPlaceSort(int[] data) {
        int n = data.length;
        for (int i = n-1; i >= 0; i--){
            // Find the maximum element in unsorted array
            int max_idx = i;
            for (int j = 0; j < i; j++) {
                if (data[j] > data[max_idx]) {
                    max_idx = j;
                }
            }
            System.out.println("\nNilai maksimum: " + data[max_idx]);

            if (data[i] < data[max_idx]) {
                System.out.println("swap " + data[max_idx] + " dengan " + data[i]);

                // Swap the found max element with the first
                // element
                int new_temp = data[max_idx];
                data[max_idx] = data[i];
                data[i] = new_temp;
            } else {
                System.out.println("tidak terjadi swap");
            }

            print(data);
        }    

    }

    private static void print(int[] data) {
        for (int i=0; i<data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println();
    }
}
