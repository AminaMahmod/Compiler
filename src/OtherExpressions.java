public class OtherExpressions {

	private NewExpression newexp;
	private boolean parsed = false;
	
	public boolean parse() {
		System.out.println("other exp");
		if(Main.code.get(Main.index).get(1).equals(","))
		{
			newexp = new NewExpression(); 
			Main.index++;
			if(newexp.parse()==true)
			{
				parsed = true;
				return true;
			}
			
		}
		else if(newexp==null)
		{
			parsed = true;
			return true;
		}
		return false;
	}

	public void prettyPrint() 
	{
		if(parsed){
			if(newexp!=null)
			{
				System.out.println(",");
				newexp.prettyPrint();
			}
		}
		else 
			System.out.println("Check the syntax First");
	}

}
