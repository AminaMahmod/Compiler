
public class ExtendsPart {
	public Identifier className ;

	public void prettyPrint() {
		if (className==null)
			System.out.print(""); // epsilon
		else {
			System.out.println("extends ");
			className.prettyPrint();
		}

	}

	public boolean parse() {
		System.out.println("extends ");
		if (Main.code.get(Main.index).get(1).equals("extends")) 
			className = new Identifier();
		if (className==null)
			return true;		// epsilon
		else if (Main.code.get(Main.index).get(1).equals("extends")) {
			Main.index++;
			if (className.parse() == true) {
				return true;
			}

		}
		return false;
	}

}
