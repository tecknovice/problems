
import java.util.*;

public class WhoWillWin {

    static int counter;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int index = 0; index < T; index++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int G = in.nextInt();
            int S = in.nextInt();
            int g = M * G;
            //build a dummy data for binary search
            int[] A = new int[N];
            for (int i = 1; i <= N; i++) {
                A[i - 1] = i;
            }
            //binary search
            counter = 0;
            binarySearch(A, 0, A.length - 1, M);
            int s = counter * S;
            System.out.println((g < s) ? 1 : (g > s ? 2 : 0));
        }
    }

    static int binarySearch(int[] A, int start, int end, int M) {
        counter += 1;
        if (end >= start) {
            //select the middle item
            int index = (start + end) / 2;
            int value = A[index];
            if (value == M) {
                return index;
            } else {
                if (value < M) {
                    return binarySearch(A, index + 1, end, M);
                } else {
                    return binarySearch(A, start, index - 1, M);
                }
            }
        }
        return -1;//not found
    }
}
