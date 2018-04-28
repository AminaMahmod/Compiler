import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int index = 0;
	public static ArrayList<ArrayList<String>> code = new ArrayList<ArrayList<String>>();

	public static boolean match(String s) {
		if (code.get(index).get(1).equals(s)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		// READ THE INPUT FILE -> CLASS : TOKEN
		File inputFile = new File("input.txt");
		Scanner sc = null;
		sc = new Scanner(inputFile);
		while (sc.hasNextLine()) {
			boolean add = true ;
			String input = "";
			input = sc.nextLine();
			String[] words;
			words = input.split(":");
			ArrayList<String> tokensWords = new ArrayList<String>();
			for (int i = 0; i < words.length; i++) {
				String word = words[i].trim();
				if (word.equals("< EOL >"))
				{
					add = false ;
					break;
				}
				tokensWords.add(word);
			}
			if (add)
				code.add(tokensWords);
		}
		sc.close();
		
		
		Goal g = new Goal();
		System.out.println("goaaaaaaaaaaaaaaaaaaaaaaaaaaaaal "+g.parse());

		if(g.parse())
		{
			g.prettyPrint();
		}
		else
			System.out.println("Syntax Error at " + code.get(index).get(1)+"\t"+index);
		
	}

	
}