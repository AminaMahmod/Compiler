import java.util.ArrayList;

public class Goal {

	private MainClass main = new MainClass();
	private ArrayList<OtherClasses> classes = new ArrayList<OtherClasses>();

	public boolean parse() {
		boolean mainClass = main.parse();
		Main.index++;
		boolean otherClasses = true;
		//OtherClasses other = new OtherClasses() ;
		/*while (other.parse()!=null)
			classes.add(other);
		/*	for (int i = 0; i < classes.size(); i++) {
			otherClasses = otherClasses && classes.get(i).parse();
			Main.index++;
		}*/
		return otherClasses && mainClass;// && Main.match("EOF");
	}

	public void prettyPrint() {
		main.prettyPrint();
		for (int i = 0; i < classes.size(); i++) {
			classes.get(i).prettyPrint();
		}
		System.out.println("EOF");
	}

}
