
public class DotPart {

	// DotPart -> "length" | Identifier "(" NewExpression ")"

	private Identifier id = new Identifier();
	private NewExpression newexp;
	
	public boolean parse() {
		System.out.println("dot");
		if(Main.code.get(Main.index).get(1).equals("length"))
		{
			Main.index++;
			return true;
		}
		else if(id.parse()==true)
		{
			if(Main.code.get(Main.index).get(1).equals("("))
			{
				Main.index++;
				if(!Main.code.get(Main.index).get(1).equals(")"))
					newexp = new NewExpression() ;
				if ( newexp == null || newexp.parse())
				{
					{
						if(Main.code.get(Main.index).get(1).equals(")"))
						{
							Main.index++;
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public void prettyPrint() {

		if(id==null)
		{
			System.out.println("length");
		}
		else if(id!=null && newexp!=null)
		{
			id.prettyPrint();
			System.out.println("(");
			newexp.prettyPrint();
			System.out.println(")");
		}
	}

}
