public class BlockStatement  extends Statement
{
	private StmtList stmtList ;
	private boolean parsed = false ;
	
	public BlockStatement() {
		super();
	}
	
	public BlockStatement(StmtList stmtList) {
		super();
		this.stmtList = stmtList;
	}

	public boolean parse() 
	{
		System.out.println("block stmt");
		
		if (Main.code.get(Main.index).get(1).equals("{")||
			Main.code.get(Main.index).get(1).equals("if")||
			Main.code.get(Main.index).get(1).equals("while")||
			Main.code.get(Main.index).get(1).equals("System.out.println")||
			Main.code.get(Main.index).get(0).equals("<ID>"))
			
			stmtList = new StmtList();
		
		if (stmtList == null || stmtList.parse())
		{
			if (Main.code.get(Main.index).get(1).equals("}"))
			{
				Main.index ++ ;
				parsed = true;
				return true ;
			}
		}
		return false;
	}
	
	public void prettyPrint()
	{
		if (parsed)
		{
			System.out.println("{");
			System.out.print("\t");
			stmtList.prettyPrint(); 
			System.out.println("}");
		}
		else
			System.out.println("Check the syntax first");
	}
	
}
