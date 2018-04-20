public class StmtList 
{
	private Statement stmt ;
	private StmtList list ;
	
	public void prettyPrint() 
	{
		if (stmt == null)
		{
			System.out.print("");
		}
		else
		{
			stmt.prettyPrint();
			list.prettyPrint();
		}
	}

	public boolean parse() 
	{
		if (stmt == null)
			return true ;
		else
		{
			return stmt.parse() && list.parse() ;
		}
	}

}
