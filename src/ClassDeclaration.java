public class ClassDeclaration {

	public Identifier className = new Identifier();
	public ExtendsPart ep;
	public ClassBody cb = new ClassBody();
	private boolean parsed= false;
	
	public boolean parse() {
		
		System.out.println("class declaration");
		if (Main.code.get(Main.index).get(1).equals("class"))
		{
			Main.index++;
			if (className.parse())
			{	
				//System.out.println("MAIN: " + Main.code.get(Main.index).get(1));

				if (Main.code.get(Main.index).get(1).equals("extends")) 
					ep = new ExtendsPart();
				if (ep==null || ep.parse() == true) {

					if (cb.parse() == true) {
						parsed = true;
						return true;
					}
				}
			}
		}
		return false;
	}

	public void prettyPrint() {
		if(parsed)
		{
			System.out.print("class ");
			className.prettyPrint();
			if (ep != null)
				ep.prettyPrint();
			cb.prettyPrint();
		}
		//else 
			//System.out.println("Check the syntax first");
	}

	
}
