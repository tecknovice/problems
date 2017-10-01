package detector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;

public class Detector {
	public static void main(String[] args) {
		DetectLanguage.apiKey = "a8db5e2f9db2068841ccce055092b9a9";
		String text = "";
		BufferedReader lineReader = null;
		try {
			for (int i = 0; i < 50; i++) {
				String f = String.format("%02d", i);
				lineReader = new BufferedReader(new FileReader("./input/input" + f + ".txt"));
				text = lineReader.readLine();
				System.out.println(text);
				String l = detectLanguage(text);
				if (l != null) {
					System.out.println(l);
				} else {
					System.out.println("");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String detectLanguage(String text) throws APIError {
		List<Result> results = DetectLanguage.detect(text);
		List<Result> r = new ArrayList<Result>();
		double c = 0D;
		String l = null;
		for (Result result : results) {
			// System.out.println("Language: " + result.language);
			// System.out.println("Is reliable: " + result.isReliable);
			// System.out.println("Confidence: " + result.confidence);
			if (result.isReliable == true) {
				r.add(result);
				if (result.confidence > c) {
					c = result.confidence;
					l = result.language;
				}
			}
		}
		if (l.equals("en"))
			l = "English";
		if (l.equals("fr"))
			l = "French";
		if (l.equals("de"))
			l = "German";
		if (l.equals("es"))
			l = "Spanish";
		return l;
	}
}
