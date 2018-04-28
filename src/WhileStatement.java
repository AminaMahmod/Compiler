public class WhileStatement extends Statement 
{
	private Expression exp = new Expression();
	private Statement stmt = new Statement();
	private boolean parsed = false;

	public WhileStatement() {
		super();
	}

	public WhileStatement(Expression exp, Statement stmt) {
		super();
		this.exp = exp;
		this.stmt = stmt;
	}

	public boolean parse() 
	{
		System.out.println("while stmt");
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
						parsed = true;
						return true; 
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
			System.out.print("while ( " );
			exp.prettyPrint();
			System.out.print(")\n");
			stmt.prettyPrint();
		}
		else
		{
			System.out.println("Check the syntax first");
		}
	}

}
