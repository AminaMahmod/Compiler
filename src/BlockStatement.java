public class BlockStatement  extends Statement
{
	private StmtList stmtList ;
	
	public boolean parse() 
	{
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
