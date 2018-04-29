public class Goal {

	private MainClass main = new MainClass();
	private OtherClasses classes ;
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
		//System.out.println("goal");
		if (Main.code.get(Main.index).get(1).equals("class"))
			main = new MainClass() ;
			if (main.parse())
			{
				if(Main.code.get(Main.index).get(0).equals("< EOF >"))
				{
					parsed = true ;
					return true;
				}
				if (Main.code.get(Main.index).get(1).equals("class"))
				{
					classes = new OtherClasses() ;
					if (classes.parse())
					{
						if(Main.code.get(Main.index).get(0).equals("< EOF >"))
						{
							parsed = true ;
							return true;
						}
					}
				}
			}
		return false;// && Main.match("EOF");
	}

	public void prettyPrint() {
		if (parsed)
		{
			main.prettyPrint();
			if (classes!=null)
				classes.prettyPrint();
		}
		//else
			//System.out.println("Check the syntax first");
	}



}
