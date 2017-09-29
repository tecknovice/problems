import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.api.GoogleAPI;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;
public class LanguageDetector {
	public static void main(String[] Args)
	{
		BufferedReader lineReader = null;
        try {
        	for (int i=0;i<50;i++) {
        		String f = String.format("%02d", i);
        		lineReader = new BufferedReader(new FileReader(".\\input\\input"+f+".txt"));
        		String text = lineReader.readLine();
        	}
        	// Set the HTTP referrer to your website address.
            GoogleAPI.setHttpReferrer(/* Enter the URL of your site here */);

            // Set the Google Translate API key
            // See: http://code.google.com/apis/language/translate/v2/getting_started.html
            GoogleAPI.setKey(/* Enter your API key here */);

            String translatedText = Translate.DEFAULT.execute("Bonjour le monde", Language.FRENCH, Language.ENGLISH);

            System.out.println(translatedText);
        } catch (Exception ex) {
            Logger.getLogger(LanguageDetector.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                lineReader.close();
            } catch (IOException ex) {
                Logger.getLogger(LanguageDetector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	}
}
