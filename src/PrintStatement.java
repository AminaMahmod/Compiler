public class PrintStatement extends Statement
{
	private Expression exp ;
	
	public PrintStatement() {
		super();
	}

	public PrintStatement(Expression exp) {
		super();
		this.exp = exp;
	}

	public boolean parse() 
	{
		if (Main.code.get(Main.index).get(1).equals("("))
		{
			Main.index ++ ;
			if (exp.parse())
			{
				if (Main.code.get(Main.index).get(1).equals("("))
				{
					Main.index ++ ;
					if (Main.code.get(Main.index).get(1).equals(";"))
					{
						Main.index ++ ;
						return true;
					}
				}
			}
		}
		return false;
	}
		
	public void prettyPrint()
	{
		System.out.print("System.out.Println(");
		exp.prettyPrint();
		System.out.println(");");
	}
}
