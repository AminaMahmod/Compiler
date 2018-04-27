
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
		if(part==null)
		{
			return true;
		}
		if(part.parse()&& f.parse())
			return true;
		
		return false;
		
	}

}
