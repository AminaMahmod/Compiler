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
			System.out.println("class ");
			className.prettyPrint();
			ep.prettyPrint();
			cb.prettyPrint();
		}
		else 
			System.out.println("Check the syntax first");
	}

	
}
