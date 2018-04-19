import java.util.ArrayList;

public class Goal {

	private MainClass main;
	private ArrayList<OtherClasses> classes;

	public boolean parse() {
		boolean mainClass = main.parse();
		Main.index++;
		boolean otherClasses = true;
		for (int i = 0; i < classes.size(); i++) {
			otherClasses = otherClasses && classes.get(i).parse();
			Main.index++;
		}
		return otherClasses && mainClass && Main.match("EOF");
	}

	public void prettyPrint() {
		main.prettyPrint();
		for (int i = 0; i < classes.size(); i++) {
			classes.get(i).prettyPrint();
		}
		System.out.println("EOF");
	}

}
