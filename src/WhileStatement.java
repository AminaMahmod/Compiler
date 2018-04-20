public class WhileStatement extends Statement 
{
	private Expression exp ;
	private Statement stmt ;

	public boolean parse() 
	{
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
						return true; 
					}
				}
			}
		}
		return false;
	}
	
	public void prettyPrint()
	{
		System.out.print("while ( " );
		exp.prettyPrint();
		System.out.print(")\n");
		stmt.prettyPrint();
	}

}
