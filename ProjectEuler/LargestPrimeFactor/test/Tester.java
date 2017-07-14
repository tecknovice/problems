
import source.SieveOfEratosthenes;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HungNV
 */
public class Tester {
    public static void main(String[] args) {
            int N = Integer.MAX_VALUE;
            List<Integer> primeList = SieveOfEratosthenes.sieves(N);
            for (Integer integer : primeList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        
    }
}
