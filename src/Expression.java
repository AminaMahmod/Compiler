public class Expression 
{
	public ExpressionFinal f;
	public Expression s;
	public Identifier id;
	public NewPart np;
	
	public String prettyPrint() {
	
		return null;
		
	}

	public boolean parse() {
		
		if(Main.code.get(Main.index).get(1).equals("this"))
				{
					Main.index++;
					if(f.parse())
						return true;
				}
		
		else if(id.parse()&& f.parse())
		{
		
				return true;
			
		}
		else if(Main.code.get(Main.index).get(1).equals("false"))
		{
			Main.index++;
			if(f.parse())
			{
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(1).equals("true"))
		{
			Main.index++;
			if(f.parse())
			{
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(1).equals("<INTEGER_LITERAL>"))
		{
			Main.index++;
			if(f.parse())
			{
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(1).equals("<FLOAT_LITERAL>"))
		{
			Main.index++;
			if(f.parse())
			{
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(1).equals("!"))
		{	
			
			Main.index++;
			if(s.parse()&& f.parse())
			{
					return true;
			}
			
		}
		else if (Main.code.get(Main.index).get(1).equals("("))
		{
			Main.index++;
			if(s.parse())
			{
				if (Main.code.get(Main.index).get(1).equals(")"))
				{
					Main.index++;
					if(f.parse())
					{
						return true;
					}
				}
			}
		}
		else if(Main.code.get(Main.index).get(1).equals("new"))
		{
			Main.index++;
			if(np.parse()&&f.parse())
			{
				return true;
			}
		}
		
	return false;	
	}

}
