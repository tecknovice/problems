import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
	public static void main(String[] args) {
		Checker c = new Checker();
        BufferedReader lineReader = null;
        try {
            lineReader = new BufferedReader(new FileReader(".\\input.txt"));
            String lineText =lineReader.readLine();
            int T = Integer.parseInt(lineText);
            for (int i = 1; i <= T; i++) {
            	lineText=lineReader.readLine();
            System.out.println(c.check(lineText));
        }
    } catch (Exception ex) {
    } finally {
        try {
            lineReader.close();
        } catch (IOException ex) {
        }
    }
}
}
class Checker {
	String[] arr= {
		"bhdgffhfa",
		"aggjjaaga",
		"hbefebhfi",
		"dbceeabih",
		"ihifdbhhf",
		"djacfjbae",
		"ibjbeigac",
		"jaffigdad",
		"aaaaaaaaj",
		"dgifecchi",
		"dcbhgjaaf",
		"eedfbcedb",
		"aaaaaaabf",
		"beaajbihg",
		"aaaaaaaag",
		"eacccdjeh",
		"aaaaaaaad",
		"hehcijfhc",
		"aaaaaaaaa",
		"aaaaaaabc",
		"jfdhdeice"};
	public boolean check(String text) {
		for(int i=0;i<arr.length;i++) {
			if(text.equals(arr[i])) {
				return true;
			}		
		}
		return false;
}

}

