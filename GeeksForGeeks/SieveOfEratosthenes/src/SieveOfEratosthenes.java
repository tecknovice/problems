
import java.util.*;

class SieveOfEratosthenes {

    static Map<Integer, Boolean> primeMap;

    public static void main(String[] args) {
        //code
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        List<Integer> primeList;
        for (int index = 1; index <= T; index++) {
            int N = in.nextInt();
            primeList = sieves(N);
            for (Integer integer : primeList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
    //Sieve Of Eratosthenes
    static List<Integer> sieves(int N) {
        primeMap = new HashMap<>();
        for (int index = 1; index <= N; index++) {
            primeMap.put(index, Boolean.TRUE);
        }

        List<Integer> primeList = new ArrayList<>();
        //start with 2
        primeList.add(2);
        int p = 2;
        while (true) {
            enumerate(p, N);
            p = getNextPrime(p);
            if (p == -1) {
                break;
            }
            primeList.add(new Integer(p));
        }
        return primeList;
    }

    // Enumerate the multiples of p up to N
    static void enumerate(int p, int N) {
        for (int index = p; index <= N; index += p) {
            primeMap.replace(index, Boolean.FALSE);
        }
    }

    static int getNextPrime(int p) {
        int index = p + 1;
        int N = primeMap.size();
        while (index <= N) {
            //check if it is next prime
            Boolean b = primeMap.get(index);
            if (b.equals(Boolean.TRUE)) {
                return index;
            } else {
                index += 1;
            }
        }
        return -1;
    }
}
