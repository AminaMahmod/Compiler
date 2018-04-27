public class If_Statement extends Statement
{
	private Expression exp ;
	private Statement stmt ;
	private ElsePart ePart ;
	
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
			if (exp.parse())
			{
				if (Main.code.get(Main.index).get(1).equals(")"))
				{
					Main.index ++ ;
					if (stmt.parse())
					{
						if (ePart.parse())
						{
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
		System.out.print("if ( ");
		exp.prettyPrint();
		System.out.println(" )");
		stmt.prettyPrint();
		ePart.prettyPrint();
		
	}
}
