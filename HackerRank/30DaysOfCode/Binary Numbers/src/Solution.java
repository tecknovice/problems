import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int remainder;
        Stack<Integer> s = new Stack<>();
        while(n>0){
            remainder=n%2;
            n=n/2;
            
            s.push(remainder);
        }
        int count=0;
        while(!s.isEmpty()){
            int i = s.pop();
            if(i==1){
                count+=1;
            }
        }
        System.out.print(count);
    }
}