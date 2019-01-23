
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Main {

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean flag = true;

        do {
            System.out.println("Pilih Algoritma yang tersedia\n1. Bubble Sort\n2. Selection Sort\n3. Insertion Sort\n" +
                    "4. Quick Sort\n5. Shell Sort\n6. Merge Sort\n7. Pencarian\n8. Hash Tabel\n0. Exit");

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
                case 7:
                    data = addData();
                    int searchNumber = askUserTheNumber();
                    searching(data, searchNumber);
                    break;
                case 8:
                    hashTable();
                    break;
                default:
                    flag = false;
                    System.out.println("Program Berakhir. Program ini dibuat oleh\nM Nurilman Baehaqi dan Dwiki\nTerimakasih telah menggunakan program ini");
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

        /* Main Selection sort operation */
        int[] arr = data;
        int n = arr.length;
    
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
                for (int j = 1; j < data.length; j++) {
                    // Get the key (The value that needs to be compared with existing
                    // values.
                    int key = data[j];
                    System.out.println("kunci: " + key);
                    // Get the array index for comparison, we need to compare with all
                    // other elements in the array with
                    // key
                    int i = j - 1;
                    // While i > 0 and when key is less than the value in the array
                    // shift the value and insert
                    // the value appropriately.
                    //System.out.println(j);
                    while (i >= 0 && data[i] < key) {
                        data[i + 1] = data[i];
                        i = i - 1;
                        data[i + 1] = key;
                    }
                    print(data);
                }

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
        System.out.println("\nMemulai proses Shell Sort..");
        System.out.println("Data sebelum di urutkan: ");
        print(data);

        /* Main shell sort operation */
        int[] arr = data;
        int n = arr.length;
    
        boolean isRepeat;

        switch (option) {
            case 1:
                //ascending
                startShellSort(arr, true);

                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            case 2:
                //descending
                startShellSort(arr, false);

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
            shellSort(data, option);
        } else {
            menu();
        }

    }

    private static void startShellSort(int[]arr, boolean isAsc) {
        int n = arr.length;
        // Start with a big gap, then reduce the gap 
                //for (int gap = n/2; gap > 0; gap /= 2)
                int gap = 1;
                while(gap <= n/3){
                    gap = 3*gap + 1;   //h is equal to highest sequence of h<=length/3 (1,4,13,40...)
                } 

                while (gap > 0)
                { 
                    System.out.println("Gap yang dipilih: " + gap);
                    // Do a gapped insertion sort for this gap size. 
                    // The first gap elements a[0..gap-1] are already 
                    // in gapped order keep adding one more element 
                    // until the entire array is gap sorted 
                    for (int i = gap; i < n; i++) { 
                        
                                       
                        // add a[i] to the elements that have been gap 
                        // sorted save a[i] in temp and make a hole at 
                        // position i 
                        int temp = arr[i]; 
        
                        // shift earlier gap-sorted elements up until 
                        // the correct location for a[i] is found >=
                        int j; 
                        
                        if(isAsc) {
                            //asc
                            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                                //System.out.println("\ni: " + i + ", j: " + j + ", arr[j - gap]: " + arr[j - gap] + ", temp: " + temp + ", arr[j]: " + arr[j]);
                                System.out.println("Terjadi penukaran " +  arr[j - gap] + " dengan " + arr[j]);
                                arr[j] = arr[j - gap];
                            }
                        } else {
                            //desc
                            for (j = i; j >= gap && arr[j - gap] <= temp; j -= gap) {
                                //System.out.println("\ni: " + i + ", j: " + j + ", arr[j - gap]: " + arr[j - gap] + ", temp: " + temp + ", arr[j]: " + arr[j]);
                                System.out.println("Terjadi penukaran " +  arr[j - gap] + " dengan " + arr[j]);
                                arr[j] = arr[j - gap];
                            }
                        }
        
                        // put temp (the original a[i]) in its correct 
                        // location 
                        arr[j] = temp; 
                        print(arr);
                    } 
                    gap = (gap - 1)/3; 
                }
    }

    private static void mergeSort(int[] data, int option) {
        System.out.println("\nMemulai proses Merge Sort..");
        System.out.println("Data sebelum di urutkan: ");
        print(data);

        /* Main Merge sort operation */
        int[] arr = data;
        int n = arr.length;
      
        boolean isRepeat;

        switch (option) {
            case 1:
                //ascending
                msort(arr, true, 0, arr.length-1); 

                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            case 2:
                //descending
                msort(arr, false, 0, arr.length-1);

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
            mergeSort(data, option);
        } else {
            menu();
        }

    }

    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    private static void merge(int arr[], boolean isAsc, int l, int m, int r) { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        System.out.println("n1: " + n1 + ", n2: " + n2);
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
        System.out.print("L array: ");
        print(L);
        System.out.print("R array: ");
        print(R);
        
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if(isAsc) {
                if (L[i] <= R[j]) 
                { 
                    arr[k] = L[i]; 
                    i++; 
                } 
                else
                { 
                    arr[k] = R[j]; 
                    j++; 
                } 
            } else {
                if (L[i] > R[j]) 
                { 
                    arr[k] = L[i]; 
                    i++; 
                } 
                else
                { 
                    arr[k] = R[j]; 
                    j++; 
                } 
            }
            k++; 
        } 
        
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
        System.out.print("Hasil merge: ");
        print(arr);
        System.out.println("===================");
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    private static void msort(int arr[], boolean isAsc, int l, int r) { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            msort(arr, isAsc, l, m);
            
            msort(arr, isAsc, m+1, r); 
            
            // Merge the sorted halves 
            merge(arr, isAsc, l, m, r);
         
        } 
    } 

    private static void quickSort(int[] data, int option) {
        System.out.println("\nMemulai proses Quick Sort..");
        System.out.println("Data sebelum di urutkan: ");
        print(data);

        /* Main quick sort operation */
        int[] arr = data;
        int n = arr.length;
        
        boolean isRepeat;

        switch (option) {
            case 1:
                //ascending
                qsort(arr, true, 0, n-1);

                System.out.println("Data setelah diurutkan:");
                print(arr);
                break;
            case 2:
                //descending
                qsort(arr, false, 0, n-1);

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
            quickSort(data, option);
        } else {
            menu();
        }

    }

    private static void qsort(int arr[], boolean isAsc, int low, int high) { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, isAsc, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            qsort(arr, isAsc, low, pi-1); 
            qsort(arr, isAsc, pi+1, high); 
        } 
    } 

    private static int partition(int arr[], boolean isAsc, int low, int high) { 
        int pivot = arr[high];  
        System.out.println("pivot is: " + pivot);
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if(isAsc) {
                //asc
                if (arr[j] <= pivot)
                { 
                    i++; 
      
                    // swap arr[i] and arr[j] 
                    //System.out.println("swap " + arr[j] + " with " + arr[i]);
                    int temp = arr[i]; 
                    arr[i] = arr[j]; 
                    arr[j] = temp; 
                
                } 
            } else {
                //desc
                if (arr[j] > pivot) 
                { 
                    i++; 
    
                    // swap arr[i] and arr[j] 
                    //System.out.println("swap " + arr[j] + " with " + arr[i]);
                    int temp = arr[i]; 
                    arr[i] = arr[j]; 
                    arr[j] = temp; 
                
                } 
            }
            
        
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
        print(arr);
  
        return i+1; 
    } 

    private static int askUserTheNumber() {
        System.out.println("Angka berapa yang akan dicari? ");
        int searchNumber = s.nextInt();
        return searchNumber;
    }

    private static void searching(int[] data, int searchNumber) {
        System.out.println("Pilihan metode pencarian\n1. Linear Search\n2. Binary Search\n3. Kembali ke menu utama");
        int optionInSearching = s.nextInt();
        switch(optionInSearching) {
            case 1:
                linearSearch(data, searchNumber);
                searching(data, searchNumber);
                break;
            case 2:
                int result = binarySearch(data, 0, data.length-1, searchNumber);
                if(result != -1) {
                    System.out.println("Data " + searchNumber + " ditemukan pada indeks ke-" + (result+1));
                } else {
                    System.out.println("Data " + searchNumber + " tidak ditemukan");
                }
                searching(data, searchNumber);
                break;
            default:
                menu();
                break;
        }
    }

    private static void linearSearch (int[] data, int searchNumber) {
        boolean isFound = false;
        int indexFounded = 0;
    
        for(int i = 0; i < data.length; i++) {
            System.out.println("Membandingkan " + data[i] + " dengan " + searchNumber);
            if(searchNumber == data[i]) {
                isFound = true;
                indexFounded = i;
                break;
            }
            
        }
        if(isFound) {
            System.out.println("Data " + searchNumber + " ditemukan pada indeks ke-" + (indexFounded+1));
            
        } else {
            System.out.println("Data " + searchNumber + " tidak ditemukan");
        }
    }

    private static int binarySearch(int arr[], int l, int r, int x) { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) {
                System.out.println("Pencarian dilakukan ke kiri");
                return binarySearch(arr, l, mid - 1, x);
            } else {
                // Else the element can only be present 
                // in right subarray 
                System.out.println("Pencarian dilakukan ke kanan");
                return binarySearch(arr, mid + 1, r, x); 
            }
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
  


    private static void hashTable() {
        System.out.println("Berapa jumlah data yang akan dimasukkan dalam hash table?");
        int n = s.nextInt();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for(int i = 0; i<n; i++) {
            System.out.println("Masukkan data ke: " + (i+1));
            int NIP = s.nextInt();
            int alamat = NIP % n;
            if(hashtable.containsKey(alamat)) {
                System.out.println("Terjadi pengalamatan terbuka. Alamat " + alamat + " sudah terisi");
                alamat = hashtable.size();
                
            }
            hashtable.put(alamat, NIP);
            System.out.println("Data " + NIP + " sukses dimasukkan ke hashtable dengan alamat " + alamat);
            
        }
        menuHashtable(hashtable);
        boolean isRepeat = askRepeat();
        if (isRepeat) {
            hashTable();
        } else {
            menu();
        }

    }

    private static void menuHashtable(Hashtable<Integer, Integer> hashtable) {
        System.out.println("Petunjuk:\n1. Tampilkan semua data\n2. Cari data\n3. Hapus data\n4. Kembali ke menu");
        int optionInHash = s.nextInt();
        switch(optionInHash) {
            case 1:
                
                for (int key : hashtable.keySet()) {
                    System.out.println("Alamat: " + key + ", NIP: " + hashtable.get(key));
                }
                menuHashtable(hashtable);
                break;
            case 2:
                System.out.println("Masukkan NIP yang akan dicari: ");
                int NIP = s.nextInt();
                if(hashtable.containsValue(NIP)) {
                    System.out.println("Data " + NIP + " ditemukan" );
                } else {
                    System.out.println("Data tidak ditemukan");
                }
                menuHashtable(hashtable);
                break;
            case 3:
                System.out.println("Masukkan alamat data yang akan dihapus: ");
                int key = s.nextInt();
                if(hashtable.containsKey(key)) {
                    hashtable.remove(key);
                    System.out.println("data dengan kunci: " + key + " sukses dihapus");
                } else {
                    System.out.println("Gagal menghapus data karena data tidak ditemukan");
                }
                menuHashtable(hashtable);
                
                break;
            
            default:
                menu();
                break;
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
        System.out.println("Berapa jumlah datanya?");
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
 
