import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in =new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i]=in.nextInt();
        }
        int pivot = A[0];
        List<Integer> right,left,equal;
        left= new ArrayList<>();
        right= new ArrayList<>();
        equal= new ArrayList<>();
        for(int i=1;i<N;i++){
            if(A[i]<pivot)left.add(new Integer(A[i]));
            if(A[i]==pivot)equal.add(new Integer(A[i]));
            if(A[i]>pivot)right.add(new Integer(A[i]));
        }
        for(Integer i : left){
            System.out.print(i+" ");
        }
        for(Integer i : equal){
            System.out.print(i+" ");
        }
        System.out.print(pivot+" ");
        for(Integer i : right){
            System.out.print(i+" ");
        }
    }
}