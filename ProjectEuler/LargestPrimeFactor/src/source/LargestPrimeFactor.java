package source;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class LargestPrimeFactor {

    public static void main(String[] args) {
        BigInteger N = new BigInteger("600851475143");
        long n = 600851475143L;
        BigInteger sqrt = calculateSquareRoot(N).toBigInteger();
        List<Integer> primeList = SieveOfEratosthenes.sieves(sqrt.intValue());
        int size = primeList.size();
        for(int i = size-1;i>=1;i--){
            if(n%primeList.get(i)==0){
                System.out.println(primeList.get(i));
        }
    }
    }

    public static BigDecimal calculateSquareRoot(BigInteger i) {
        //initial value
        BigDecimal d = new BigDecimal(i.toString());
        BigDecimal x = BigDecimal.ONE;
        BigDecimal x1, x2;
        BigDecimal TWO = new BigDecimal("2");
        while (true) {
            x1 = x;
            x2 = d.divide(x1, 10, BigDecimal.ROUND_HALF_EVEN);
            x = (x1.add(x2)).divide(TWO, 10, BigDecimal.ROUND_HALF_EVEN);
            if (x.equals(x1) || x.equals(x2)) {
                return x;
            }
        }
    }

    public static boolean checkPrimeNumber(BigInteger i) {
        BigDecimal d = calculateSquareRoot(i);
        BigInteger sqrt = d.toBigInteger();
        BigInteger[] arr;
        BigInteger divisor, remainder;
        BigInteger index;
        for (index = BigInteger.valueOf(2L); index.compareTo(sqrt) <= 0; index = index.add(BigInteger.ONE)) {
            arr = i.divideAndRemainder(index);
            divisor = arr[0];
            remainder = arr[1];
            if (remainder.equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }
}
