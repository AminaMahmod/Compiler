import java.util.ArrayList;

public class Body {

	private VariableDeclaration var;
	private BodyStatement bodystmt;
	private boolean parsed = false;
	private static ArrayList<String> types = new ArrayList<>();

	public Body(VariableDeclaration var, BodyStatement bodystmt) {
		this.bodystmt = bodystmt;
		this.var = var;
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");
	}
	
	public Body()
	{
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");
	}
	
	public boolean parse() {
		System.out.println("body");
		if (types.contains(Main.code.get(Main.index).get(0)))
			var = new VariableDeclaration();
		if (var.parse())
		{	
			if (Main.code.get(Main.index).get(1).equals("{") ||
				Main.code.get(Main.index).get(1).equals("if")||
				Main.code.get(Main.index).get(1).equals("while")||
				Main.code.get(Main.index).get(1).equals("System.out.println")||
				Main.code.get(Main.index).get(0).equals("< ID >")
				)
				bodystmt = new BodyStatement();
			
			if (bodystmt.parse() == true) 
			{
				parsed = true;
				return true;
			}
		}
		return false;
	}

	public void prettyPrint() {
		if (parsed)
		{
			if(var != null)
				var.prettyPrint();
			if(bodystmt != null)
				bodystmt.prettyPrint();
		}
		else
			System.out.println("Check the syntax first");
	}

}
