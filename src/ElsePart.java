public class ElsePart 
{
	private Statement stmt ; 
	boolean parsed = false;
	
	public ElsePart(Statement stmt) {
		super();
		this.stmt = stmt;
	}
	
	public ElsePart() {
		super();
	}

	public void prettyPrint() {
		
		if (parsed)
		{
			if (stmt != null)
			{
				System.out.println("else");
				stmt.prettyPrint();
			}
		}
		else 
			System.out.println("Check the syntax first");
	}

	public boolean parse() {
		
		System.out.println("else part");
		if (Main.code.get(Main.index).get(1).equals("else"))
		{
			Main.index ++ ;

			if (Main.code.get(Main.index).get(1).equals("{"))
				stmt = new Statement();
			else if (Main.code.get(Main.index).get(1).equals("if"))
				stmt = new Statement();
			else if (Main.code.get(Main.index).get(1).equals("while"))
				stmt = new Statement();
			else if (Main.code.get(Main.index).get(1).equals("System.out.println"))
				stmt = new Statement();
			else if (Main.code.get(Main.index).get(0).equals("< ID >"))
				stmt = new Statement();
			
			if (stmt.parse())
			{
				parsed = true;
				return true;
			}
		}
		
		return false;
	}
}
