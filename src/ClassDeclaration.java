
public class ClassDeclaration {
	public Identifier className;
	public ExtendsPart ep;
	public ClassBody cb;

	public boolean parse() {
		System.out.println("class declaration");
		if (Main.code.get(Main.index).get(1).equals("class"))
		{
			Main.index++;
			if (className.parse())
			{
				if (ep.parse() == true) {
					if (cb.parse() == true) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void prettyPrint() {
		System.out.println("class ");
		className.prettyPrint();
		ep.prettyPrint();
		cb.prettyPrint();
	}

}
