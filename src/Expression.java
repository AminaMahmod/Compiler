public class Expression 
{
	public ExpressionFinal f;
	public Expression s;
	public Identifier id;
	public NewPart np;
	public static String type;
	public int integer;
	public float flt;
	
	public Expression() {
		super();
	}

	
	public Expression(ExpressionFinal f,Expression s,Identifier id,NewPart np,int integer,float flt)
	
	{
			this.f=f;
			this.s=s;
			this.id=id;
			this.np=np;
			this.integer=integer;
			this.flt=flt;
	}
	public void prettyPrint() {
	
		if(type=="this")
		{	
			System.out.println("this");
			f.prettyPrint();
		}
		else if(type=="id")
		{
			id.prettyPrint();
			f.prettyPrint();
		}
		else if(type=="false")
		{
			System.out.println("false");
			f.prettyPrint();
		}
		else if (type=="true")
		{
			System.out.println("true");
			f.prettyPrint();
		}
		else if(type=="int")
		{
			System.out.println(integer);
			f.prettyPrint();
		}
		else if (type=="float")
		{
			System.out.println(flt);
			f.prettyPrint();
		}
		else if (type=="expln")
		{
			System.out.println("!");
			s.prettyPrint();
			f.prettyPrint();
		}
		else if (type=="aqwas")
		{
			System.out.println("(");
			s.prettyPrint();
			System.out.println(")");
			f.prettyPrint();
		}
		else if(type=="new")
		{
			System.out.println("new");
			np.prettyPrint();
			f.prettyPrint();
		}
		
	}

	public boolean parse() {
		return true;
/*		if(Main.code.get(Main.index).get(1).equals("this"))
				{
					Main.index++;
					if(f.parse())
						{
						type="this";
						return true;
						}
				}
		
		else if(id.parse()&& f.parse())
		{
				type="id";
				return true;
			
		}
		else if(Main.code.get(Main.index).get(1).equals("false"))
		{
			Main.index++;
			if(f.parse())
			{
				type="false";
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(1).equals("true"))
		{
			Main.index++;
			if(f.parse())
			{
				type="true";
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(1).equals("<INTEGER_LITERAL>"))
		{
			Main.index++;
			if(f.parse())
			{
				type="int";
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(1).equals("<FLOAT_LITERAL>"))
		{
			Main.index++;
			if(f.parse())
			{
				type="float";
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(1).equals("!"))
		{	
			
			Main.index++;
			if(s.parse()&& f.parse())
			{
					type="expln";
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
						type="aqwas";
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
				type="new";
				return true;
			}
		}
		
	return false;	
	*/}

}
