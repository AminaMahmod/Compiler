public class Goal {

	private MainClass main = new MainClass();
	private OtherClasses classes = new OtherClasses();
	
	public Goal() {
		super();
	}

	public Goal(MainClass main,OtherClasses classes) {
		super();
		this.main = main;
		this.classes = classes;
	}
	
	public boolean parse() {
		System.out.println("goal");
		return main.parse() && classes.parse() ;// && Main.match("EOF");
	}

	public void prettyPrint() {
		main.prettyPrint();
		classes.prettyPrint();
	}



}
