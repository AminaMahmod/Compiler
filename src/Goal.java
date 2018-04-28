public class Goal {

	private MainClass main = new MainClass();
	private OtherClasses classes = new OtherClasses();
	private boolean parsed = false; 
	
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
		if (Main.code.get(Main.index).get(1).equals("class"))
			main = new MainClass() ;
			if (main.parse())
			{
				if (Main.code.get(Main.index).get(1).equals("class"))
				{
					classes = new OtherClasses() ;
					if (classes.parse())
					{
						parsed = true ;
						return true;
					}
				}
			}
		return false;// && Main.match("EOF");
	}

	public void prettyPrint() {
		if (parsed)
		{
			main.prettyPrint();
			classes.prettyPrint();
		}
		else
			System.out.println("Check the syntax first");
	}



}
