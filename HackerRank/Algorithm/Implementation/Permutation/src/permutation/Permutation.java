/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author hungn_000
 */
public class Permutation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer> superSet = new ArrayList<>();
        superSet.add(1);
        superSet.add(2);
        superSet.add(3);
        superSet.add(4);
        superSet.add(5);
        superSet.add(6);
        superSet.add(7);
        superSet.add(8);
        superSet.add(9);
        superSet.add(10);
        superSet.add(11);
        superSet.add(12);
        superSet.add(13);
        superSet.add(14);
        superSet.add(15);
        superSet.add(16);
        superSet.add(17);
        superSet.add(18);
        superSet.add(19);
        superSet.add(20);
        List<Set<Integer>> res= getSubsets(superSet,9);
        System.out.println(res.size());
        System.out.println(res);
    }
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
    
}
