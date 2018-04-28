public class ExpressionFinal {

	private ExpressionPart part;
	private ExpressionFinal f;
	private boolean parsed = false;

	public boolean initFinalOperator() {
		if (Main.code.get(Main.index).get(1).equals("&&") || Main.code.get(Main.index).get(1).equals("||")
				|| Main.code.get(Main.index).get(1).equals("==") || Main.code.get(Main.index).get(1).equals("!=")
				|| Main.code.get(Main.index).get(1).equals("+") || Main.code.get(Main.index).get(1).equals("-")
				|| Main.code.get(Main.index).get(1).equals("*") || Main.code.get(Main.index).get(1).equals("/")
				|| Main.code.get(Main.index).get(1).equals(">") || Main.code.get(Main.index).get(1).equals("<")
				|| Main.code.get(Main.index).get(1).equals(">=") || Main.code.get(Main.index).get(1).equals("<=")
				|| Main.code.get(Main.index).get(1).equals(".") || Main.code.get(Main.index).get(1).equals("[")) {

			return true;
		}
		return false;
	}

	public void prettyPrint() {
		if (parsed) {
			if (part != null) {
				part.prettyPrint();
				if (f != null)
					f.prettyPrint();
			}
		} else
			System.out.println("Check the syntax first");
	}

	public boolean parse() {
		System.out.println("exp final");
		
		if (initFinalOperator())
			part = new ExpressionPart();
		if (part == null) {
			parsed = true;
			return true;
		}
		if (part.parse()) {
			if (initFinalOperator())
				f = new ExpressionFinal();
			if (f == null ||f.parse()) {
				parsed = true;
				return true;
			}
		}

		return false;
	}
}