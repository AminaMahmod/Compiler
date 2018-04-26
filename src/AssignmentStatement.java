public class AssignmentStatement extends Statement
{
	private Identifier id ;
	private IndexPart index ;
	private Expression exp ;
	
	public AssignmentStatement() {
		super();
	}
		
	public AssignmentStatement(Identifier id, IndexPart index, Expression exp) {
		super();
		this.id = id;
		this.index = index;
		this.exp = exp;
	}

	public boolean parse() 
	{
		if (index.parse())
		{
			if (Main.code.get(Main.index).get(1).equals("="))
			{
				Main.index ++ ;
				if (exp.parse())
				{
					if (Main.code.get(Main.index).get(1).equals(";"))
					{
						Main.index++ ;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void prettyPrint()
	{
		id.prettyPrint();
		index.prettyPrint();
		System.out.print(" = ");
		exp.prettyPrint();
	}

}
