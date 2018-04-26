
public class Operator {

	//Operator -> "&&" | "||" | "==" | "!=" | "+" | "-" | "*" | "/"  | ">" Equal | "<" Equal 
	private String opt;
	
	public boolean parse() {
		if(Main.code.get(Main.index).get(1).equals("&&"))
		{
			opt = "&&" ;
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("||"))
		{
			opt = "||" ;
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("=="))
		{
			opt = "==" ;
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("!="))
		{
			opt = "!=" ;
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("+"))
		{
			opt = "+" ;
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("-"))
		{
			opt = "-" ;
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("*"))
		{
			opt = "*" ;
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("/"))
		{
			opt = "/" ;
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals(">"))
		{
			opt = ">" ;
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("<"))
		{
			opt = "<" ;
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals(">="))
		{
			opt = ">=" ;
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("<="))
		{
			opt = "<=" ;
			Main.index++;
			return true;
		}
		return false;
	}

	public void prettyPrint() {
		
		System.out.print(opt);
	}

}
