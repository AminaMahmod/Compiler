
public class ExpressionFinal {
	
	ExpressionPart part;
	ExpressionFinal f;
	
	public void prettyPrint()
	{
		
	}
	
	public boolean parse()
	{
		if(part.parse()&& f.parse())
			return true;
		if(part==null)
		{
			return true;
		}
		return false;
		
	}

}
