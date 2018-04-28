public class Expression 
{
	private ExpressionFinal f ;
	private Expression s;
	private Identifier id;
	private NewPart np = new NewPart();
	private String type;
	private int integer;
	private float flt;
	private boolean parsed = false;
	
	public Expression() {
		super();
	}

	public void initFinalOperator(){
		if(Main.code.get(Main.index).get(1).equals("&&") 
				|| Main.code.get(Main.index).get(1).equals("||")
				|| Main.code.get(Main.index).get(1).equals("==")
				|| Main.code.get(Main.index).get(1).equals("!=")
				|| Main.code.get(Main.index).get(1).equals("+")
				|| Main.code.get(Main.index).get(1).equals("-")
				|| Main.code.get(Main.index).get(1).equals("*")
				|| Main.code.get(Main.index).get(1).equals("/")
				|| Main.code.get(Main.index).get(1).equals(">")
				|| Main.code.get(Main.index).get(1).equals("<")
				|| Main.code.get(Main.index).get(1).equals(">=")
				|| Main.code.get(Main.index).get(1).equals("<=")
				|| Main.code.get(Main.index).get(1).equals(".")
				|| Main.code.get(Main.index).get(1).equals("[")
				)
		{
			f = new ExpressionFinal(); 
		}
	}
	public void initExp(){
		if(Main.code.get(Main.index).get(1).equals("this")
				||Main.code.get(Main.index).get(1).equals("new")
				||Main.code.get(Main.index).get(1).equals("false")
				||Main.code.get(Main.index).get(0).equals("<INTEGERAL_LITERAL>")
				||Main.code.get(Main.index).get(0).equals("<FLOAT_LITERAL>")
				||Main.code.get(Main.index).get(0).equals("<ID>")
				||Main.code.get(Main.index).get(1).equals("!")
				||Main.code.get(Main.index).get(1).equals("true")
				||Main.code.get(Main.index).get(1).equals("("))
		{
			s = new Expression(); 
		}
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
	public void prettyPrint() 
	{
		if (parsed){
		
			if(type=="this")
			{	
				System.out.print("this");
				f.prettyPrint();
			}
			else if(type=="id")
			{
				id.prettyPrint();
				f.prettyPrint();
			}
			else if(type=="false")
			{
				System.out.print("false");
				f.prettyPrint();
			}
			else if (type=="true")
			{
				System.out.print("true");
				f.prettyPrint();
			}
			else if(type=="int")
			{
				System.out.print(integer);
				f.prettyPrint();
			}
			else if (type=="float")
			{
				System.out.print(flt);
				f.prettyPrint();
			}
			else if (type=="expln")
			{
				System.out.print("!");
				s.prettyPrint();
				f.prettyPrint();
			}
			else if (type=="aqwas")
			{
				System.out.print("(");
				s.prettyPrint();
				System.out.print(")");
				f.prettyPrint();
			}
			else if(type=="new")
			{
				System.out.println("new");
				np.prettyPrint();
				if (f!=null)
					f.prettyPrint();
			}
		}
		else 
			System.out.println("Check the syntax first");
	}

	public boolean parse() 
	{
		System.out.println("expression");
		f = new ExpressionFinal();
		id = new Identifier() ;
		np = new NewPart() ;
				
		if(Main.code.get(Main.index).get(1).equals("this"))
		{	
			Main.index++;
			initFinalOperator();
			if(f==null || f.parse())
			{
				type="this";
				parsed= true;
				return true;
			}
		}
		else if(Main.code.get(Main.index).get(1).equals("false"))
		{
			Main.index++;
			initFinalOperator();
			if(f==null || f.parse())
			{
				type="false";
				parsed= true;
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(1).equals("true"))
		{
			Main.index++;
			initFinalOperator();
			if(f==null || f.parse())
			{
				type="true";
				parsed= true;
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(0).equals("<INTEGERAL_LITERAL>"))
		{
			integer = Integer.parseInt(Main.code.get(Main.index).get(1));
			Main.index++;
			initFinalOperator();
			if(f==null || f.parse())
			{
				type="int";
				parsed= true;
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(0).equals("<FLOAT_LITERAL>"))
		{
			flt = Float.parseFloat(Main.code.get(Main.index).get(1));
			Main.index++;
			initFinalOperator();
			if(f==null || f.parse())
			{
				type="float";
				parsed= true;
				return true;
			}
		}
		else if (Main.code.get(Main.index).get(1).equals("!"))
		{	
			Main.index++;
			initExp();
			if(s.parse()){
				initFinalOperator();
				if(f==null || f.parse())
				{
					type="expln";
					parsed= true;
					return true;
				}
			}
		}
		else if (Main.code.get(Main.index).get(1).equals("("))
		{
			Main.index++;
			initExp();
			if(s.parse())
			{
				if (Main.code.get(Main.index).get(1).equals(")"))
				{
					Main.index++;
					initFinalOperator();
					if(f==null || f.parse())
					{	
						type="aqwas";
						parsed= true;
						return true;
					}
				}
			}
		}
		else if(Main.code.get(Main.index).get(1).equals("new"))
		{
			Main.index++;
			initFinalOperator();
			if(f==null || np.parse()&&f.parse())
			{
				type="new";
				parsed= true;
				return true;
			}
		}
		else if(id.parse()&& f.parse())
		{
			type="id";
			parsed= true;
			return true;
		}
		
		return false;	
	}

}
