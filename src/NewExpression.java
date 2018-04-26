
public class NewExpression {

	private Expression exp;
	private OtherExpressions otherexp;
	
	public boolean parse() {
		if(exp.parse()==true)
		{
			if(otherexp.parse()==true)
			{
				return true;
			}
		}
		return false;
	}

	public void prettyPrint() 
	{
		exp.prettyPrint();
		otherexp.prettyPrint();
	}

}
