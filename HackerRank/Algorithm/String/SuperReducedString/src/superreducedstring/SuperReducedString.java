package superreducedstring;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SuperReducedString {
    static String super_reduced_string(String s){
        char[] carr= s.toCharArray();
        List<Character> l = new ArrayList<>();
        for (char c : carr) {            
            l.add(c);
        }
        while(true){
            int removePoint=-1;
            for (int i = 0; i < l.size()-1; i++) {
                if(l.get(i)==l.get(i+1)){
                   removePoint=i;
                   break;
                }
            }
            if(removePoint==-1){
                break;
            }
            l.remove(removePoint+1);
            l.remove(removePoint); 
        }
        if(l.size()==0) return "Empty String";
        StringBuffer sb = new StringBuffer();
        for (Character character : l) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);

    }
}
