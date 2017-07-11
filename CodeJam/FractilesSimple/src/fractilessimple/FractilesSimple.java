/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractilessimple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author hungn_000
 */
public class FractilesSimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          BufferedReader lineReader = null;
        try {
            lineReader = new BufferedReader(new FileReader("C:\\Users\\hungn_000\\Downloads\\D-small-practice.in"));
            String lineText = null;
            lineText = lineReader.readLine();
            int T = Integer.parseInt(lineText);
            int K,C,S;
            for (int i = 1; i <= T; i++) {
                lineText = lineReader.readLine();
                String[] arr =  lineText.split(" ",3);
                K=Integer.parseInt(arr[0]);
                C=Integer.parseInt(arr[1]);
                S=Integer.parseInt(arr[2]);
                System.out.print("Case #"+i+":");
                for(int j=1;j<=K;j++){
                    System.out.print(" "+j);
                }
                System.out.println("");
            }
             } catch (Exception ex) {
        } finally {
            try {
                lineReader.close();
            } catch (IOException ex) {

            }
        }
    }
    
}
