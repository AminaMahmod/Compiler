public class BlockStatement  extends Statement
{
	private StmtList stmtList ;
	
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
		if (stmtList.parse())
		{
			if (Main.code.get(Main.index).get(1).equals("}"))
			{
				Main.index ++ ;
				return true ;
			}
		}
		return false;
	}
	
	public void prettyPrint()
	{
		System.out.println("{");
		System.out.print("\t");
		stmtList.prettyPrint(); 
		System.out.println("}");
	}
	
}
