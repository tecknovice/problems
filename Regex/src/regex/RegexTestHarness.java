package regex;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
    	String s = scan.next();
        while (true) {
        	System.out.println("%nEnter your regex: ");
            Pattern pattern = Pattern.compile(scan.next());
            System.out.println("Enter input string to search: ");
            Matcher matcher = pattern.matcher(scan.next());

            boolean found = false;
            while (matcher.find()) {
                console.format("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
            if(!found){
                console.format("No match found.%n");
            }
        }
    }
}