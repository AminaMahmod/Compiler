
public class ExtendsPart {
	public Identifier className ;
	private boolean parsed = false;

	public void prettyPrint() {
		if (parsed)
		{
			if (className==null)
				System.out.print(""); // epsilon
			else {
				System.out.print(" extends ");
				className.prettyPrint();
			}
		}
		System.out.println("\nCheck the syntax first");

	}

	public boolean parse() {
		System.out.println("extends ");
		if (Main.code.get(Main.index).get(1).equals("extends")) 
			className = new Identifier();
		if (className==null)
		{
			parsed = true;
			return true;		// epsilon
		}
		else if (Main.code.get(Main.index).get(1).equals("extends")) {
			Main.index++;
			if (className.parse() == true) {
				parsed = true;
				return true;
			}

		}
		return false;
	}

}
