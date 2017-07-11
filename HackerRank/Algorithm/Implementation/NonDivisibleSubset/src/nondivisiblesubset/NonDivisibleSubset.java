package nondivisiblesubset;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NonDivisibleSubset {
    private static void getSubsets(List<Integer> superSet, int k, int idx, Set<Integer> current,List<Set<Integer>> solution) {
    //successful stop clause
    if (current.size() == k) {
        solution.add(new HashSet<>(current));
        return;
    }
    //unsuccessful stop clause
    if (idx == superSet.size()) return;
    Integer x = superSet.get(idx);
    current.add(x);
    //"guess" x is in the subset
    getSubsets(superSet, k, idx+1, current, solution);
    current.remove(x);
    //"guess" x is not in the subset
    getSubsets(superSet, k, idx+1, current, solution);
}

    public static List<Set<Integer>> getSubsets(List<Integer> superSet, int k) {
    List<Set<Integer>> res = new ArrayList<>();
    getSubsets(superSet, k, 0, new HashSet<Integer>(), res);
    return res;
}
    public static void main(String[] args) {
                 BufferedReader lineReader = null;
        try {
            lineReader = new BufferedReader(new FileReader("C:\\Users\\hungn_000\\Downloads\\test.in"));
            String lineText = null;
            lineText = lineReader.readLine();
            String[] arr1 = new String[2];
            arr1=lineText.split(" ");
            int N = Integer.valueOf(arr1[0]);
            int K = Integer.valueOf(arr1[1]);
            String[] arr2= new String[N];
            lineText = lineReader.readLine();
            arr2=lineText.split(" ");
        //get the set
        List<Integer> superSet = new ArrayList<>();   
        for (int i = 0; i < N; ++i){
            Integer integer =new Integer(arr2[i]);
            superSet.add(integer);
        }
        //get the subset from size N to size 2
            for (int i = N; i >=2; i--) {
                List<Set<Integer>> subSetS = getSubsets(superSet, i);
                //for each subset size i, get pairs of integer
                for (Set<Integer> set : subSetS) {
                    boolean validSet=true;
                    List<Set<Integer>> pairs = getSubsets(new ArrayList<Integer>(set), 2);
                    //for each pair, check divisibility for K
                    for (Set<Integer> pair : pairs) {
                        Integer[] pairArray = new Integer[2];
                        pair.toArray(pairArray);
                        int sum = pairArray[0]+pairArray[1];
                        if(sum%K==0){
                            validSet=false;
                            break;
                        }
                    }
                    if(validSet==true){
                        System.out.println(i);
                        System.out.println(set);
                        return;
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getStackTrace());
        } finally {
            try {
                lineReader.close();
            } catch (IOException ex) {

            }
        }
    }
}