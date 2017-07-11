/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingsheep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hungn_000
 */
public class CountingSheep {

    /**
     * @param args the command line arguments
     */
    static Set<Integer> s;
    static List<Integer> l;

    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader lineReader = null;
        try {
            lineReader = new BufferedReader(new FileReader("C:\\Users\\hungn_000\\Downloads\\A-large-practice.in"));
            String lineText = null;
            lineText = lineReader.readLine();
            int num_testcase = Integer.parseInt(lineText);
            // Execute testcases
            for (int i = 1; i <= num_testcase; i++) {
                s = new HashSet<Integer>();
                lineText = lineReader.readLine();
                int n = Integer.parseInt(lineText);
                if (n == 0) {
                    System.out.println("Case #" + i + ": " + "INSOMNIA");
                    continue;
                }
                long next = n;
//                System.out.println(next);
                getDigits(n);
//                System.out.println(s.toString());
                //Counting sheeep
                while (s.size() < 10) {
                    next = next + n;
//                    System.out.println(next);
                    getDigits(next);
//                    System.out.println(s.toString());
                }
                System.out.println("Case #" + i + ": " + next);
            }
        } catch (Exception ex) {
        } finally {
            try {
                lineReader.close();
            } catch (IOException ex) {

            }
        }
    }

    public static void getDigits(long n) {
        do {
            if (n < 10) {
                s.add((int) n);
                break;
            }
            s.add((int) (n % 10));
            n = n / 10;

        } while (true);
    }

}
