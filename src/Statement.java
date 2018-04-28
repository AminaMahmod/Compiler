public class Statement {

	private Statement stmt ;
	private boolean parsed = false;
	
	public void prettyPrint() {
		if (parsed)
			stmt.prettyPrint(); 
		else
			System.out.println("Check the syntax first");
	}

	public boolean parse() 
	{
		System.out.println("stmt");
		if (Main.code.get(Main.index).get(1).equals("{"))
			stmt = new BlockStatement();
		else if (Main.code.get(Main.index).get(1).equals("if"))
			stmt = new If_Statement();
		else if (Main.code.get(Main.index).get(1).equals("while"))
			stmt = new WhileStatement();
		else if (Main.code.get(Main.index).get(1).equals("System.out.println"))
			stmt = new PrintStatement();
		else if (Main.code.get(Main.index).get(0).equals("<ID>"))
			stmt = new AssignmentStatement();
		else
			return false;
			
		Main.index ++ ;
		if (stmt.parse())
		{
			parsed = true;
			return true;
		}
		else
			return false;
	}
}
