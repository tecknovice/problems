/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package source;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HungNV
 */
public class SieveOfEratosthenes_BigIntegerVersion {
static Map<BigInteger, Boolean> primeMap;

    //Sieve Of Eratosthenes
    public static List<BigInteger> sieves(BigInteger N) {
        primeMap = new HashMap<>();
        for (BigInteger index = BigInteger.ONE; index.compareTo(N)<=0; index.add(BigInteger.ONE)) {
            primeMap.put(index, Boolean.TRUE);
        }

        List<BigInteger> primeList = new ArrayList<>();
        //start with 2
        
        BigInteger p = BigInteger.valueOf(2L);
        primeList.add(p);
        while (true) {
            enumerate(p, N);
            p = getNextPrime(p,N);
            if (p.compareTo(BigInteger.ZERO)==0) {
                break;
            }
            primeList.add(p);
        }
        return primeList;
    }

    // Enumerate the multiples of p up to N
    static void enumerate(BigInteger p, BigInteger N) {
        for (BigInteger index = new BigInteger(p.toString()); index.compareTo(N)<=0; index.add(p)) {
            primeMap.replace(index, Boolean.FALSE);
        }
    }

    static BigInteger getNextPrime(BigInteger p,BigInteger N) {
        BigInteger index = p.add(BigInteger.ONE);
        while (index.compareTo(N)<=0) {
            //check if it is next prime
            Boolean b = primeMap.get(index);
            if (b.equals(Boolean.TRUE)) {
                return index;
            } else {
                index.add(BigInteger.ONE);
            }
        }
        return BigInteger.ZERO;
    }
}
