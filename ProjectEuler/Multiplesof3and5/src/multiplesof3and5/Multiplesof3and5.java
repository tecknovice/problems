/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplesof3and5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author hungn_000
 */
public class Multiplesof3and5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Set<Integer> hs = new HashSet<Integer>();
        int x =0;
        do{
           x+=3; 
           hs.add(x);
        }while(x<997);
        x=0;
        do{
           x+=5; 
           hs.add(x);
        }while(x<995);
        Iterator<Integer> i = hs.iterator();
        int sum = 0;
        while (i.hasNext()) {
            int a  = i.next().intValue();
             sum += a;
             System.out.println(a);
            
        }
        System.out.println(sum);
    }
//    Iterator<Integer> i =
//    hs
    
}
