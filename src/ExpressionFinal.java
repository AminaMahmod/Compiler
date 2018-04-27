
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
		if(part.parse()&& f.parse())
			return true;
		if(part==null)
		{
			return true;
		}
		return false;
		
	}

}
