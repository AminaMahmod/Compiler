public class ElsePart 
{
	private Statement stmt ; 
	
	public ElsePart(Statement stmt) {
		super();
		this.stmt = stmt;
	}
	
	public void prettyPrint() {
		System.out.println("else part");
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
