
public class NewExpression {

	private Expression exp;
	private OtherExpressions otherexp;
	
	public boolean parse() {
		if(exp.parse()==true)
		{
			if(otherexp.parse()==true || otherexp == null)
			{
				return true;
			}
		}
		return false;
	}

	public void prettyPrint() 
	{
		exp.prettyPrint();
		if (otherexp != null)
			otherexp.prettyPrint();
	}

}
