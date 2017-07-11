/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hungn_000
 */
public class Gravity {

    /**
     * @param args the command line arguments
     */
    static boolean[][] A;

    public static void main(String[] args) {
        BufferedReader lineReader = null;
        try {
            lineReader = new BufferedReader(new FileReader("C:\\Users\\hungn_000\\Downloads\\input.txt"));
            String lineText = null;
            lineText = lineReader.readLine();
            int num_testcase = Integer.parseInt(lineText);
            //build boolean matrix
            
            int[] output = new int[2];
            for (int i = 1; i <= num_testcase; i++) {
                A = new boolean[10][20];
                lineText = lineReader.readLine();
                String[] cols = lineText.split("\\s");
                for (int x = 0; x <= 9; x++) {
                    int col_high = Integer.parseInt(cols[x]);
                    for (int y = 0; y < col_high; y++) {
                        A[x][y] = true;
                    }
                }
                output = fall();
                System.out.println(output[0]);
                System.out.println(output[1]);
            }
            lineReader.close();
        } catch (Exception ex) {
            Logger.getLogger(Gravity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                lineReader.close();
            } catch (IOException ex) {
                Logger.getLogger(Gravity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    static int[] fall() {
        int max_distance = 0;
        int happend_col = -1;
        for (int y = 19; y >= 0; y--) {
            int impact_point = 10;
            for (int x = 9; x >= 0; x--) {
                if (A[x][y] == true) {
                    //falling
                    impact_point--;
                    A[x][y] = false;
                    A[impact_point][y] = true;
                    //caculate distance
                    if (impact_point - x > max_distance) {
                        max_distance = impact_point - x;
                        happend_col = x;
                    }
                }
            }
        }
        return new int[]{max_distance, happend_col};
    }

}
