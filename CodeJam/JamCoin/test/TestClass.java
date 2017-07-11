/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungn_000
 */
import coinjam.CoinJam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
public class TestClass {
    public static void main(String[] args) {
        Boolean d;
       BufferedReader br = null;

        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.print("Enter a integer : ");
                String input = br.readLine();

                if ("quit".equals(input)) {
                    System.out.println("Exit!");
                    System.exit(0);
                }
                d= CoinJam.checkPrimeNumber(new BigInteger(input));
                System.out.println("input : " + input);
                System.out.println("is prime number: "+d);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
