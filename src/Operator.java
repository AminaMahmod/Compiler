
public class Operator {

	//Operator -> "&&" | "||" | "==" | "!=" | "+" | "-" | "*" | "/"  | ">" Equal | "<" Equal 
	private String opt;
	private boolean parsed = false;
	
	public boolean parse() {
		System.out.println("operator");
		if(Main.code.get(Main.index).get(1).equals("&&"))
		{
			opt = "&&" ;
			Main.index++;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("||"))
		{
			opt = "||" ;
			Main.index++;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("=="))
		{
			opt = "==" ;
			Main.index++;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("!="))
		{
			opt = "!=" ;
			Main.index++;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("+"))
		{
			opt = "+" ;
			Main.index++;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("-"))
		{
			opt = "-" ;
			Main.index++;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("*"))
		{
			opt = "*" ;
			Main.index++;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("/"))
		{
			opt = "/" ;
			Main.index++;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals(">"))
		{
			opt = ">" ;
			Main.index++;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("<"))
		{
			opt = "<" ;
			Main.index++;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals(">="))
		{
			opt = ">=" ;
			Main.index++;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("<="))
		{
			opt = "<=" ;
			Main.index++;
			parsed = true;
			return true;
		}

		return false;
	}

	public void prettyPrint() {
		
		if (parsed)
			System.out.print(opt);
		else
			System.out.println("Check the Syntax First");
	}

}
