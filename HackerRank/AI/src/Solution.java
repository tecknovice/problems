import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
	public static void main(String[] args) {
        BufferedReader lineReader = null;
        try {
            lineReader = new BufferedReader(new FileReader(".\\input.txt"));
            String lineText =lineReader.readLine();
            int T = Integer.parseInt(lineText);
            for (int i = 1; i <= T; i++) {
            	lineText=lineReader.readLine();
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

