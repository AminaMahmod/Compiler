public class StmtList 
{
	private Statement stmt = new Statement();
	private StmtList list ;
	private boolean parsed = false;
	
	public StmtList(Statement stmt, StmtList list) {
		super();
		this.stmt = stmt;
		this.list = list;
	}

	public StmtList() {
	}

	public void prettyPrint() 
	{
		if (parsed)
		{
			stmt.prettyPrint();
			if (list!=null)
				list.prettyPrint();
		}
		else
		{
			System.out.println("Check the syntax first");
		}
	}

	public boolean parse() 
	{
		System.out.println("stmt list");
		
		if (stmt.parse())
		{
			if (Main.code.get(Main.index).get(1).equals("{")||
					Main.code.get(Main.index).get(1).equals("if")||
					Main.code.get(Main.index).get(1).equals("while")||
					Main.code.get(Main.index).get(1).equals("System.out.println")||
					Main.code.get(Main.index).get(0).equals("< ID >"))
					
					list = new StmtList();
			if (list == null ||list.parse())
			{
				parsed = true ;
				return true;
			}
		}
		return false;
	
	}

}
