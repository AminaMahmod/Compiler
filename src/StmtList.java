public class StmtList 
{
	private Statement stmt ;
	private StmtList list ;
	
	public StmtList(Statement stmt, StmtList list) {
		super();
		this.stmt = stmt;
		this.list = list;
	}

	public void prettyPrint() 
	{
		if (stmt != null)
		{
			stmt.prettyPrint();
			list.prettyPrint();
		}
	}

	public boolean parse() 
	{
		System.out.println("stmt list");
		if (stmt == null)
			return true ;
		else
		{
			return stmt.parse() && list.parse() ;
		}
	}

}
