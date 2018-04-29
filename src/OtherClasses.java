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
		//else
			//System.out.println("Check the syntax first");
			
	}

	public boolean parse()
	{		
		System.out.println("other classes");
		if(Main.code.get(Main.index).get(0).equals("< EOF >"))
		{
			parsed = true ;
			return true;
		}
		if (cd.parse()) 
		{
			if (Main.code.get(Main.index).get(1).equals("class"))
				others = new OtherClasses() ;
			if ( others == null||others.parse() )
			{
				parsed = true ;
				return true ;
			}
		} 
		return false;
	}

}