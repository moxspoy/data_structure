package sorting;

import java.util.Scanner;

public class TigaSorting {

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean flag = true;

        do {
            System.out.println("Pilih Operasi Pengurutan\n1. Bubble Sort\n2. Selection Sort\n3. Insertion Sort\n" +
                    "4. Quick Sort\n5. Shell Sort\n6. Merge Sort\n0. Exit");

            int input = s.nextInt();
            int option;
            int[] data;
            switch (input) {
                case 1:
                    data = addData();
                    option = askOrderedData();
                    bubbleSort(data, option);
                    break;
                case 2:
                    data = addData();
                    option = askOrderedData();
                    selectionSort(data, option);
                    break;
                case 3:
                    data = addData();
                    option = askOrderedData();
                    insertionSort(data, option);
                    break;
                case 4:
                    data = addData();
                    option = askOrderedData();
                    quickSort(data, option);
                    break;
                case 5:
                    data = addData();
                    option = askOrderedData();
                    shellSort(data, option);
                    break;
                case 6:
                    data = addData();
                    option = askOrderedData();
                    mergeSort(data, option);
                    break;
                default:
                    flag = false;
                    System.out.println("Program Berakhir. Terimakasih telah menggunakan program ini");
                    System.exit(0);
                    break;
            }
        } while (flag);
    }

    private static void bubbleSort(int[] data, int option) {

        System.out.println("\nMemulai proses Bubble Sort..");
        System.out.println("Data sebelum di urutkan: ");
        print(data);

        /* Main bubble sort operation */
        int[] arr = data;
        int n = arr.length;
        int temp;
        boolean isRepeat;

        switch (option) {
            case 1:
                //ascending
                for(int i=0; i < n; i++){
                    for(int j=1; j < (n-i); j++){
                        if(arr[j-1] > arr[j]){
                            System.out.println("elemen " + arr[j-1] + " di swap dengan " + arr[j] );
                            //swap elements
                            temp = arr[j-1];
                            arr[j-1] = arr[j];
                            arr[j] = temp;
                            print(arr);
                        }
//                        print(arr);
                    }
                }

                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            case 2:
                //descending
                for (int i = 0; i < ( n - 1 ); i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (arr[j] < arr[j+1])
                        {
                            System.out.println("elemen " + arr[j] + " di swap dengan " + arr[j+1] );
                            temp = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] = temp;
                            print(arr);
                        }
                    }
                }

                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            default:
                System.out.println("Pilih 1 atau 2 saja!");

        }

        isRepeat = askRepeat();
        if (isRepeat) {
            data = addData();
            option = askOrderedData();
            bubbleSort(data, option);
        } else {
            menu();
        }

    }

    private static void selectionSort(int[] data, int option) {
        System.out.println("\nMemulai proses Selection Sort..");
        System.out.println("Data sebelum di urutkan: ");
        print(data);

        /* Main bubble sort operation */
        int[] arr = data;
        int n = arr.length;
        int temp;
        boolean isRepeat;

        switch (option) {
            case 1:
                //ascending
                // One by one move boundary of unsorted subarray
                for (int i = 0; i < n-1; i++)
                {
                    // Find the minimum element in unsorted array
                    int min_idx = i;
                    for (int j = i+1; j < n; j++) {
                        if (data[j] < data[min_idx]) {
                            min_idx = j;
                        }
                    }
                    System.out.println("Nilai minimum: " + data[min_idx]);

                    if (data[i] != data[min_idx]) {
                        System.out.println("swap " + data[min_idx] + " dengan " + data[i]);

                        // Swap the found minimum element with the first
                        // element
                        int new_temp = data[min_idx];
                        data[min_idx] = data[i];
                        data[i] = new_temp;
                    } else {
                        System.out.println("tidak terjadi swap");
                    }

                    print(data);
                }

                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            case 2:
                //descending
                int in, out;
                int max;
                int new_temp;
                for (out = 0; out <arr.length; out++) {
                    // The default maximum number of positions
                    max = out;
                    for (in = out + 1; in <arr.length; in++) {
                        if (arr[max] <arr[in]) {
                            // Gets the maximum number of positions
                            max = in;
                        }
                    }
                    System.out.println("Nilai maksimum: " + arr[max]);
                    // When the maximum number of default position and the maximum number is not practical, location of the exchange and the maximum number of actual
                    if (out != max) {
                        System.out.println("swap " + arr[max] + " dengan " + arr[out]);
                        new_temp = arr[out];
                        arr[out] = arr[max];
                        arr[max] = new_temp;
                    } else {
                        System.out.println("tidak terjadi swap");
                    }
                    print(arr);
                }
                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            default:
                System.out.println("Pilih 1 atau 2 saja!");

        }

        isRepeat = askRepeat();
        if (isRepeat) {
            data = addData();
            option = askOrderedData();
            selectionSort(data, option);
        } else {
            menu();
        }

    }

    private static void insertionSort(int[] data, int option) {
        System.out.println("\nMemulai proses Insertion Sort..");
        System.out.println("Data sebelum di urutkan: ");
        print(data);

        /* Main insertion sort operation */
        int n = data.length;
        int temp;
        boolean isRepeat;

        switch (option) {
            case 1:
                //ascending
                for (int i=1; i<n; ++i)
                {
                    int key = data[i];
                    int j = i-1;
                    /* Move elements of arr[0..i-1], that are
                    greater than key, to one position ahead
                    of their current position */
                    System.out.println("kunci: " + key);
                    while (j>=0 && data[j] > key)
                    {
                        data[j+1] = data[j];
                        j = j-1;
                    }
                    data[j+1] = key;
                    print(data);
                }

                System.out.println("Data setelah diurutkan:");
                print(data);
                break;
            case 2:
                //descending


                System.out.println("Data setelah diurutkan:");
                print(data);
                break;
            default:
                System.out.println("Pilih 1 atau 2 saja!");

        }

        isRepeat = askRepeat();
        if (isRepeat) {
            data = addData();
            option = askOrderedData();
            insertionSort(data, option);
        } else {
            menu();
        }

    }

    private static void shellSort(int[] data, int option) {
        System.out.println("\nMemulai proses Insertion Sort..");
        System.out.println("Data sebelum di urutkan: ");
        print(data);

        /* Main insertion sort operation */
        int[] arr = data;
        int n = arr.length;
        int temp;
        boolean isRepeat;

        switch (option) {
            case 1:
                //ascending


                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            case 2:
                //descending


                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            default:
                System.out.println("Pilih 1 atau 2 saja!");

        }

        isRepeat = askRepeat();
        if (isRepeat) {
            data = addData();
            option = askOrderedData();
            insertionSort(data, option);
        } else {
            menu();
        }

    }

    private static void mergeSort(int[] data, int option) {
        System.out.println("\nMemulai proses Insertion Sort..");
        System.out.println("Data sebelum di urutkan: ");
        print(data);

        /* Main insertion sort operation */
        int[] arr = data;
        int n = arr.length;
        int temp;
        boolean isRepeat;

        switch (option) {
            case 1:
                //ascending


                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            case 2:
                //descending


                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            default:
                System.out.println("Pilih 1 atau 2 saja!");

        }

        isRepeat = askRepeat();
        if (isRepeat) {
            data = addData();
            option = askOrderedData();
            insertionSort(data, option);
        } else {
            menu();
        }

    }

    private static void quickSort(int[] data, int option) {
        System.out.println("\nMemulai proses Insertion Sort..");
        System.out.println("Data sebelum di urutkan: ");
        print(data);

        /* Main insertion sort operation */
        int[] arr = data;
        int n = arr.length;
        int temp;
        boolean isRepeat;

        switch (option) {
            case 1:
                //ascending


                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            case 2:
                //descending


                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            default:
                System.out.println("Pilih 1 atau 2 saja!");

        }

        isRepeat = askRepeat();
        if (isRepeat) {
            data = addData();
            option = askOrderedData();
            insertionSort(data, option);
        } else {
            menu();
        }

    }


    private static boolean askRepeat() {
        System.out.println("Apakah anda ingin mengulang ?\n1. Ya\n2. Tidak");
        int repeat = s.nextInt();
        boolean yes;
        switch (repeat) {
            case 1:
                yes = true;
                break;
            case 2:
                yes = false;
                break;
            default:
                System.out.println("Pilih 1 atau 2 saja!");
                yes = false;
                break;
        }
        return yes;
    }

    private static int askOrderedData() {
        System.out.println("Pilih\n1. Ascending\n2. Descending");
        int askDesc = s.nextInt();
        return  askDesc;
    }

    private static int[] addData() {
        System.out.println("Berapa jumlah data yang akan di urutkan?");
        int numOfElement = s.nextInt();
        int[] arrData = new int[numOfElement];
        for (int i=0; i<numOfElement; i++) {
            System.out.println("Masukkan data ke: "+ (i+1));
            arrData[i] = s.nextInt();
        }
        System.out.println("Berhasil menambahkan data");
        return arrData;

    }

    private static void print(int[] data) {
        for (int i=0; i<data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println();
    }
}
