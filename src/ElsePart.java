public class ElsePart 
{
	public ElsePart(Statement stmt) {
		super();
		this.stmt = stmt;
	}

	private Statement stmt ; 
	
	public void prettyPrint() {
		if (stmt == null)
			System.out.print("");
		else
		{
			System.out.println("else");
			stmt.prettyPrint();
		}
	}

	public boolean parse() {
		
		if (Main.code.get(Main.index).get(1).equals("else"))
		{
			Main.index ++ ;
			if (stmt.parse())
			{
				return true;
			}
		}
		
		return false;
	}
}
