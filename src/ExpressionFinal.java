
public class ExpressionFinal {
	
	ExpressionPart part;
	ExpressionFinal f;
	
	public void prettyPrint()
	{
		if(part!=null)
		{
			part.prettyPrint();
			f.prettyPrint();
		}
	}
	
	public boolean parse()
	{
		System.out.println("exp final");
		Operator op = new Operator(); 
		if (Main.code.get(Main.index).get(1).equals("[") ||
			Main.code.get(Main.index).get(1).equals(".") || op.parse() )
		{
			part = new ExpressionPart() ;
		}
		if(part==null)
		{
			return true;
		}
		if(part.parse()&& f.parse())
			return true;
		
		return false;
		
	}

}
