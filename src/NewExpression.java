
public class NewExpression {

	private Expression exp;
	private OtherExpressions otherexp;
	
	public boolean parse() {
		exp = new Expression() ;
		System.out.println("New exp");
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
