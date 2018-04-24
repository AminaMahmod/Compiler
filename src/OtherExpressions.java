
public class OtherExpressions {

	//OtherExpressions -> "," NewExpression | epsilon
	private NewExpression newexp;
	public boolean parse() {
		if(Main.code.get(Main.index).get(1).equals(","))
		{
			Main.index++;
			if(newexp.parse()==true)
			{
				return true;
			}
			
		}
		else if(newexp==null)
		{
			return true;
		}
		return false;
	}

	public void prettyPrint() 
	{
		if(newexp!=null)
		{
			System.out.println(",");
			newexp.prettyPrint();
		}
		
	}

}
