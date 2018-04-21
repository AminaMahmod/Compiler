
public class Operator {

	//Operator -> "&&" | "||" | "==" | "!=" | "+" | "-" | "*" | "/"  | ">" Equal | "<" Equal 
	private String opt;
	public boolean parse() {
		if(Main.code.get(Main.index).get(1).equals("&&"))
		{
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("||"))
		{
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("=="))
		{
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("!="))
		{
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("+"))
		{
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("-"))
		{
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("*"))
		{
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("/"))
		{
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals(">"))
		{
			Main.index++;
		
		}
		else if(Main.code.get(Main.index).get(1).equals("<"))
		{
			Main.index++;
		}
		else if(Main.code.get(Main.index).get(1).equals(">="))
		{
			Main.index++;
		
		}
		else if(Main.code.get(Main.index).get(1).equals("<="))
		{
			Main.index++;
		}
		return false;
	}

	public void prettyPrint() {
		
		System.out.println(opt);
	}

}
