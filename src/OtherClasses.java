public class OtherClasses {
	private ClassDeclaration cd ;
	private OtherClasses others ;

	public void prettyPrint() {
		
		if (cd != null)
		{
			cd.prettyPrint();
			if (others != null)
				others.prettyPrint();
		}
			
	}

	public boolean parse()
	{
		System.out.println("other classes");
		if (cd==null)
		{
			return true;
		}
		if (cd.parse()) 
		{
			if (others.parse() || others == null)
				return true ;
		} 
		return false;
	}

}
