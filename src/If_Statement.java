public class If_Statement extends Statement
{
	private Expression exp ;
	private Statement stmt ;
	private ElsePart ePart ;
	private boolean parsed = false ;
	
	public If_Statement() {
		super();
	}

	public If_Statement(Expression exp, Statement stmt, ElsePart ePart) {
		super();
		this.exp = exp;
		this.stmt = stmt;
		this.ePart = ePart;
	}

	public boolean parse() 
	{
		System.out.println("if stmt");
		if (Main.code.get(Main.index).get(1).equals("("))
		{
			Main.index ++ ;
			exp = new Expression() ;
			
			if (exp.parse())
			{
				if (Main.code.get(Main.index).get(1).equals(")"))
				{
					Main.index ++ ;
					stmt = new Statement();
					if (stmt.parse())
					{
						if (Main.code.get(Main.index).get(1).equals("else"))
							ePart = new ElsePart(); 
						
						if (ePart==null||ePart.parse())
						{
							parsed = true;
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public void prettyPrint()
	{
		if (parsed)
		{
			System.out.print(Main.printTabs(Main.tabsCounter));
			System.out.print("if ( ");
			exp.prettyPrint();
			System.out.print(" )\n");
			if (!stmt.getClass().equals("BodyStatement"))
				Main.tabsCounter++;
			stmt.prettyPrint();
			if (!stmt.getClass().equals("BodyStatement"))
				Main.tabsCounter--;
			if (ePart!=null)
				ePart.prettyPrint();
		}
		else
		{
			//System.out.println("Check the syntax first");
		}
	}
}
