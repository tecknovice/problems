/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evenfibonaccinumbers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungn_000
 */
public class EvenFibonacciNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long start = System.currentTimeMillis();
        int x= 1;
        int y = 2;
        int xy =0;
        List<Integer> l = new ArrayList<Integer>();
        l.add(x);
        l.add(y);
        while(xy<4000000){
            xy = x+y;
            x=y;
            y = xy;
            l.add(xy);
        }
        long sum=0;
        l.remove(l.size()-1);
        for (Integer i : l) {
            if(i%2==0){
                sum+=i;
            }
        }
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"s");
    }
    
}
