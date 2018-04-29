public class AssignmentStatement extends Statement
{
	private Identifier id ;
	private IndexPart index ;
	private Expression exp ;
	
	public AssignmentStatement() {
		super();
	}
		
	public AssignmentStatement(Identifier id, IndexPart index, Expression exp) {
		super();
		this.id = id;
		this.index = index;
		this.exp = exp;
	}

	public Identifier getId() {
		return id;
	}

	public void setId(Identifier id) {
		this.id = id;
	}

	public IndexPart getIndex() {
		return index;
	}

	public void setIndex(IndexPart index) {
		this.index = index;
	}

	public Expression getExp() {
		return exp;
	}

	public void setExp(Expression exp) {
		this.exp = exp;
	}

	public boolean parse() 
	{
		System.out.println("= stmt");
		id = new Identifier();
		Main.index -- ;
		id.parse();
		if (Main.code.get(Main.index).get(1).equals("["))
			index = new IndexPart();
		if (index == null || index.parse())
		{
			if (Main.code.get(Main.index).get(1).equals("="))
			{
				Main.index ++ ;
				exp = new Expression() ;
				if (exp.parse())
				{
					if (Main.code.get(Main.index).get(1).equals(";"))
					{
						Main.index++ ;
						parsed = true ;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void prettyPrint()
	{
		if (parsed)
		{
			System.out.print(Main.printTabs(Main.tabsCounter));
			id.prettyPrint();
			if (index != null)
				index.prettyPrint();
			System.out.print(" = ");
			exp.prettyPrint();
			System.out.println(";");
		}
	}

}
