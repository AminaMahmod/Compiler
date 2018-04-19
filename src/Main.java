import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int index = 0;
	public static ArrayList<ArrayList<String>> code;

	public static boolean match(String s) {
		if (code.get(index).get(1).equals(s)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		File inputFile = new File("input.txt");
		Scanner sc = null;
		sc = new Scanner(inputFile);
		while (sc.hasNextLine()) {
			String input = "";
			input = sc.nextLine();
			String[] words;
			words = input.split(":");
			ArrayList<String> tokensWords = new ArrayList<String>();
			for (int i = 0; i < words.length; i++) {
				String word = words[i].trim();
				tokensWords.add(word);
			}
			code.add(tokensWords);
		}
		sc.close();
		
	}

	
}