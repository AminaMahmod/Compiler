public class OtherClasses {
	private ClassDeclaration cd = new ClassDeclaration() ;
	private OtherClasses others ;
	private boolean parsed = false;

	public void prettyPrint() {
		if (parsed)
		{
			if (cd != null)
			{
				cd.prettyPrint();
				if (others != null)
					others.prettyPrint();
			}
		}
		else
			System.out.println("Check the syntax first");
			
	}

	public boolean parse()
	{		
		System.out.println("other classes");
		
		if (cd.parse()) 
		{
			if (Main.code.get(Main.index).get(1).equals("class"))
				others = new OtherClasses() ;
			if (others.parse() || others == null)
			{
				parsed = true ;
				return true ;
			}
		} 
		return false;
	}

}