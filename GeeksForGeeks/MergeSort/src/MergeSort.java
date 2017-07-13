
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungn_000
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr =  new int[]{23,43,34,5456,45,65,6,7,678,78,79,89,0,0,-05645,6767,787878,98945,432,423,4,4,4,43,454,6,7,68,7,9,67676,565,78,65,87,8};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int arr[], int l, int r) {
        GfG g = new GfG();
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            g.merge(arr, l, m, r);
        }
    }
}
