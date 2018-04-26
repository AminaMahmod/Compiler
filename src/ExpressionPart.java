
public class ExpressionPart {
	//ExpressionPart -> Operator Expression | "[" Expression "]" | "." DotPart
	private Operator op;
	private Expression exp;
	private DotPart dp;

	public boolean parse()
	{
		if(op.parse()==true)
		{
			if(exp.parse()==true)
			{
				return true;
			}
		}
		else if(Main.code.get(Main.index).get(1).equals("["))
		{
			Main.index++;
			if(exp.parse()==true)
			{
				if(Main.code.get(Main.index).get(1).equals("]"))
				{
					return true;
				}
			}
		}
		else if(Main.code.get(Main.index).get(1).equals("."))
		{
			if(dp.parse()==true)
			{
				return true;
			}
		}
		return false;
	}
	
	public void prettyPrint()
	{
		if(op!=null)
		{
			op.prettyPrint();
			exp.prettyPrint();
		}
		else if(exp!=null)
		{
			System.out.println("[");
			exp.prettyPrint();
			System.out.println("]");		
		}
		else if(dp!=null)
		{
			System.out.println(".");
			dp.prettyPrint();
		}
	}
}
