
import java.util.*;

class QuickSort {

    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N;
        int[] A;
        for (int index = 0; index < T; index++) {
            N = sc.nextInt();
            A = new int[N];
            int e;
            for (int i = 0; i < N; i++) {
                e = sc.nextInt();
                A[i] = e;
            }
            //quick sort
            quickSort(A, 0, A.length - 1);
            for (int i : A) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, A[p] is now
               at right place */
            int pi = partition(A, low, high);

            quickSort(A, low, pi - 1);  // Before pi
            quickSort(A, pi + 1, high); // After pi
        }
    }
    //From CRLS Book
    public static int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low - 1;
        int temp;
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (A[j] <= pivot) {
                i++;    // increment index of smaller element
                //swap A[i] and A[j]
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        //swap A[i + 1] and A[high])
        i = i + 1;
        temp = A[i];
        A[i] = A[high];
        A[high] = temp;
        return i;
    }
}
