
public class ExtendsPart {
	public Identifier className;

	public void prettyPrint() {
		if (className==null)
			System.out.print(""); // epsilon
		else {
			System.out.println("extends");
			Main.index++;
			className.prettyPrint();
			Main.index++;
		}

	}

	public boolean parse() {
		if (className==null) {
			return true;		// epsilon
		} else if (Main.code.get(Main.index).get(1).equals("extends")) {
			Main.index++;
			if (className.parse() == true) {
				Main.index++;
				return true;
			}

		} else {
			return false;
		}
		return false;
	}

}
