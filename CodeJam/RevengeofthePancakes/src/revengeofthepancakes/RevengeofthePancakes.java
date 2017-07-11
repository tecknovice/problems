/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revengeofthepancakes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author hungn_000
 */
public class RevengeofthePancakes {

    /**
     * @param args the command line arguments
     */
    static Stack s;
    static List<Character> l;
    static int maneuvertimes;

    public static void main(String[] args) {
        // TODO code application logic here/
        //loop over the test case
        BufferedReader lineReader = null;
        try {
            lineReader = new BufferedReader(new FileReader("C:\\Users\\hungn_000\\Downloads\\B-large-practice.in"));
            String lineText = null;
            lineText = lineReader.readLine();
            int num_testcase = Integer.parseInt(lineText);

            for (int i = 1; i <= num_testcase; i++) {
                l = new LinkedList<Character>();
                s = new Stack();
                maneuvertimes = 0;
                lineText = lineReader.readLine();
                System.out.println("Case #" + i + ": " + lineText);
                for (char c : lineText.toCharArray()) {
                    l.add(c);
                }
                pushtoStack();
                recursive();
//                System.out.println("maneuvertimes:" + maneuvertimes);
                System.out.println("Case #" + i + ": " + maneuvertimes);
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        } finally {
            try {
                lineReader.close();
            } catch (IOException ex) {

            }
        }
    }

    static void recursive() {
        //base case
        if (l.size() == 0) {
            return;
        }
        int pointer = checktopofthecakesStack();
        if (pointer != -1) {
            flipOver(0, pointer);
        }
        flipOver(0, l.size() - 1);
        pushtoStack();
        recursive();

    }

    static void pushtoStack() {
        int size;
        Character c;
        while (true) {

            size = l.size();
            if (size == 0) {
                break;
            }
            c = l.get(size - 1);
            if (c == '+') {
                s.push(c);
                l.remove(size - 1);
            } else {
                break;
            }

        }
        System.out.println("After push to stack: " + "L " + list2String(l) + " S " + list2String(s));
    }

    static void flipOver(int x, int y) {
        Stack<Character> tempStack = new Stack<Character>();
        Character a;
        for (int i = x; i <= y; i++) {
            a = l.get(i);
            if (a.equals('+')) {
                l.set(i, '-');
            } else {
                l.set(i, '+');
            }
        }
        Character b;
        for (int i = x; i <= y; i++) {
            b = l.get(i);
            tempStack.push(b);
        }
        l.subList(x, y + 1).clear();

        Character c;
        for (int i = x; i <= y; i++) {
            try {
                c = tempStack.pop();
            } catch (Exception e) {
                break;
            }
            l.add(i, c);
        }
        maneuvertimes += 1;
        System.out.println("After flip over: " + "L " + list2String(l) + " S " + list2String(s));
    }

    static int checktopofthecakesStack() {
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) == '+') {

            } else {
                return (i - 1);
            }
        }
        return (-1);
    }

    static String list2String(List<Character> chars) {
        StringBuilder result = new StringBuilder(chars.size());
        for (Character c : chars) {
            result.append(c);
        }
        String output = result.toString();
        return output;
    }

}
