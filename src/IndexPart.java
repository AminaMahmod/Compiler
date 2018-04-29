public class IndexPart 
{
	private Expression exp ;
	private boolean parsed = false;
	
	public IndexPart(Expression exp) {
		super();
		this.exp = exp;
	}

	public IndexPart() {
	}

	public void prettyPrint() {
		if (parsed)
		{
			if (exp != null)
			{
				System.out.print("[ ");
				exp.prettyPrint();
				System.out.print(" ]");
			}
		}
		//else
			//System.out.println("Check the syntax first");
	}

	public boolean parse() {
		System.out.println("index");

		if (Main.code.get(Main.index).get(1).equals("["))
		{
			Main.index ++ ;
			exp = new Expression() ;
			if (exp.parse())
			{
				if (Main.code.get(Main.index).get(1).equals("]"))
				{
					Main.index ++ ;
					parsed = true;
					return true;
				}
			}
			
		}
		
		return false;
	}
}
