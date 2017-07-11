/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinjam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;
import java.math.BigInteger;

/**
 *
 * @author hungn_000
 */
public class CoinJam {
    public static final BigInteger TWO = new BigInteger("2");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         BufferedReader lineReader = null;
        try {
            lineReader = new BufferedReader(new FileReader("C:\\Users\\hungn_000\\Downloads\\C-small-practice.in"));
            String lineText = null;
            lineText = lineReader.readLine();
            int num_testcase = Integer.parseInt(lineText);
            int N,J;
            // Execute testcases
            for (int i = 1; i <= num_testcase; i++) {
                int j=0;
                lineText = lineReader.readLine();
                String[] arr =  lineText.split(" ",2);
                N=Integer.parseInt(arr[0]);
                J=Integer.parseInt(arr[1]);
                ArrayList<String> a = generateBinaryString(N);
                for (String str : a) {
                    if(checkCoinJam(str)){
                        j+=1;
                        if(j>J)break;
                        BigInteger[] il = getListNontrivialDivisor(str);
                        System.out.print(str);
                        System.out.print(" ");
                        System.out.print(il[0].toString());
                        System.out.print(" ");
                        System.out.print(il[1].toString());
                        System.out.print(" ");
                        System.out.print(il[2].toString());
                        System.out.print(" ");
                        System.out.print(il[3].toString());
                        System.out.print(" ");
                        System.out.print(il[4].toString());
                        System.out.print(" ");
                        System.out.print(il[5].toString());
                        System.out.print(" ");
                        System.out.print(il[6].toString());
                        System.out.print(" ");
                        System.out.print(il[7].toString());
                        System.out.print(" ");
                        System.out.print(il[8].toString());
                        System.out.println();
                    }
                        
                }
            }
        } catch (Exception ex) {
        } finally {
            try {
                lineReader.close();
            } catch (IOException ex) {

            }
        }
    }
        public static ArrayList<String> generateBinaryString(int N){
        ArrayList<String> returnList = new ArrayList<>();
        long upper_bound = (long)Math.pow(2, N)-1;
        long lower_bound = (long)Math.pow(2, N-1)+1;
        long X;
        Stack<Long> s;
        StringBuffer str;
        for(long i=lower_bound;i<=upper_bound;i++){
            s = new Stack<>();
            str = new StringBuffer();
            X=i;
            for(int j=0;j<N;j++){
                s.push(X%2);
                X=X/2;
            }
            while(true){
                str.append(String.valueOf(s.pop()));
                if(s.isEmpty()) break;
            }
//            System.out.println(str);
            returnList.add(str.toString());
        }
        return returnList;
    }
    public static boolean checkCoinJam(String str){
        int length = str.length();
        if(str.charAt(0)=='0'||str.charAt(length-1)=='0')return false;
        //base 2
        boolean prime = false;
        BigInteger base2val = new BigInteger(str, 2);
        prime = checkPrimeNumber(base2val);
        if(prime) return false;
        BigInteger base3val = new BigInteger(str, 3);
        prime = checkPrimeNumber(base3val);
        if(prime) return false;
        BigInteger base4val = new BigInteger(str, 4);
        prime = checkPrimeNumber(base4val);
        if(prime) return false;
        BigInteger base5val = new BigInteger(str, 5);
        prime = checkPrimeNumber(base5val);
        if(prime) return false;
        BigInteger base6val = new BigInteger(str, 6);
        prime = checkPrimeNumber(base6val);
        if(prime) return false;
        BigInteger base7val = new BigInteger(str, 7);
        prime = checkPrimeNumber(base7val);
        if(prime) return false;
        BigInteger base8val = new BigInteger(str, 8);
        prime = checkPrimeNumber(base8val);
        if(prime) return false;
        BigInteger base9val = new BigInteger(str, 9);
        prime = checkPrimeNumber(base9val);
        if(prime) return false;
        BigInteger base10val = new BigInteger(str, 10);
        prime = checkPrimeNumber(base10val);
        if(prime) return false;
        return true;
    }
    public static boolean checkPrimeNumber(BigInteger i){
        BigDecimal d= calculateSquareRoot(i);
        BigInteger sqrt=d.toBigInteger();
        BigInteger[] arr;
        BigInteger divisor,remainder;
        BigInteger index;
        for ( index = BigInteger.valueOf(2L); index.compareTo(sqrt)<=0; index=index.add(BigInteger.ONE)) {
            arr=i.divideAndRemainder(index);
            divisor=arr[0];
            remainder=arr[1];
            if(remainder.equals(BigInteger.ZERO))return false;
        }
        return true;
    }
    public static BigDecimal calculateSquareRoot(BigInteger i){
        //initial value
        BigDecimal d = new BigDecimal(i.toString());
        BigDecimal x=BigDecimal.ONE;
        BigDecimal x1,x2;
        BigDecimal TWO = new BigDecimal("2");
        while(true){
            x1=x;
            x2=d.divide(x1,10,BigDecimal.ROUND_HALF_EVEN);
            x=(x1.add(x2)).divide(TWO,10,BigDecimal.ROUND_HALF_EVEN);
            if(x.equals(x1)||x.equals(x2))return x;
        }
    }
    public static BigInteger[] getListNontrivialDivisor(String str){
        BigInteger[] il = new BigInteger[9];
        BigInteger base2val = new BigInteger(str, 2);
        il[0] = getNontrivialDivisor(base2val);
        BigInteger base3val = new BigInteger(str, 3);
        il[1] = getNontrivialDivisor(base3val);
        BigInteger base4val = new BigInteger(str, 4);
        il[2] = getNontrivialDivisor(base4val);
        BigInteger base5val = new BigInteger(str, 5);
        il[3] = getNontrivialDivisor(base5val);
        BigInteger base6val = new BigInteger(str, 6);
        il[4] = getNontrivialDivisor(base6val);
        BigInteger base7val = new BigInteger(str, 7);
        il[5] = getNontrivialDivisor(base7val);
        BigInteger base8val = new BigInteger(str, 8);
        il[6] = getNontrivialDivisor(base8val);
        BigInteger base9val = new BigInteger(str, 9);
        il[7] = getNontrivialDivisor(base9val);
        BigInteger base10val = new BigInteger(str, 10);
        il[8] = getNontrivialDivisor(base10val);
        return il;
    }
    public static BigInteger getNontrivialDivisor(BigInteger i){
        BigDecimal d= calculateSquareRoot(i);
        BigInteger sqrt=d.toBigInteger();
        BigInteger[] arr;
        BigInteger divisor,remainder;
        BigInteger index;
        for ( index = BigInteger.valueOf(2L); index.compareTo(sqrt)<=0; index=index.add(BigInteger.ONE)) {
            arr=i.divideAndRemainder(index);
            divisor=arr[0];
            remainder=arr[1];
            if(remainder.equals(BigInteger.ZERO))return index;
        }
        return null;
    }
}
