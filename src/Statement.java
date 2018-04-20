public class Statement {

	private Statement stmt ;
	
	public void prettyPrint() {
		stmt.prettyPrint(); 

	}

	public boolean parse() 
	{
		if (Main.code.get(Main.index).get(1).equals("{"))
			stmt = new BlockStatement();
		else if (Main.code.get(Main.index).get(1).equals("if"))
			stmt = new If_Statement();
		else if (Main.code.get(Main.index).get(1).equals("while"))
			stmt = new WhileStatement();
		else if (Main.code.get(Main.index).get(1).equals("System.out.Println"))
			stmt = new PrintStatement();
		else if (Main.code.get(Main.index).get(0).equals("<IDENTIFIER>"))
			stmt = new AssignmentStatement();

			
		Main.index ++ ;
		if (stmt.parse())
			return true;
		else
			return false;
	}
}
