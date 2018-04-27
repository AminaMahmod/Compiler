public class IndexPart 
{
	private Expression exp ;
	
	public IndexPart(Expression exp) {
		super();
		this.exp = exp;
	}

	public void prettyPrint() {
		if (exp != null)
		{
			System.out.print("[");
			exp.prettyPrint();
			System.out.print("]");
		}
	}

	public boolean parse() {
		System.out.println("index");
		if (exp == null)
			return true; 
		if (Main.code.get(Main.index).get(1).equals("["))
		{
			Main.index ++ ;
			if (exp.parse())
			{
				if (Main.code.get(Main.index).get(1).equals("]"))
				{
					Main.index ++ ;
					return true;
				}
			}
			
		}
		
		return false;
	}
}
