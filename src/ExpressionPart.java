
public class ExpressionPart {
	// ExpressionPart -> Operator Expression | "[" Expression "]" | "." DotPart
	private Operator op = new Operator();
	private Expression exp;
	private DotPart dp;
	private boolean parsed = false;

	public boolean parse() {
		System.out.println("exp part");

		if (Main.code.get(Main.index).get(1).equals(".")) {
			Main.index++;
			dp = new DotPart();
			if (dp.parse() == true) {
				parsed = true;
				return true;
			}
		} else if (Main.code.get(Main.index).get(1).equals("[")) {
			Main.index++;
			exp = new Expression();
			if (exp.parse() == true) {
				if (Main.code.get(Main.index).get(1).equals("]")) {
					Main.index++;
					parsed = true;
					return true;
				}
			}
		} else if (op.parse() == true) {
			exp = new Expression() ;
			if (exp.parse() == true) {
				parsed = true;
				return true;
			}
		}
		return false;
	}

	public void prettyPrint() {
		if (parsed) {
			if (exp != null) {
				System.out.println("[");
				exp.prettyPrint();
				System.out.println("]");
			} else if (dp != null) {
				System.out.println(".");
				dp.prettyPrint();
			} else if (op != null) {
				op.prettyPrint();
				exp.prettyPrint();
			}
		}
		else 
			System.out.println("Check the syntax first");
	}
}
