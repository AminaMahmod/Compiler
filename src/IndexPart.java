public class IndexPart 
{
	private Expression exp ;
	
	public void prettyPrint() {
		if (exp != null)
		{
			System.out.print("[");
			exp.prettyPrint();
			System.out.print("]");
		}
	}

	public boolean parse() {
		
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
