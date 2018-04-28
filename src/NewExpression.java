public class NewExpression {

	private Expression exp;
	private OtherExpressions otherexp;
	private boolean parsed = false;

	public boolean parse() {
		exp = new Expression();
		System.out.println("New exp");
		if (exp.parse() == true) {
			if (Main.code.get(Main.index).get(1).equals(","))
				otherexp = new OtherExpressions();
			if (otherexp == null || otherexp.parse() == true) {
				parsed = true;
				return true;
			}
		}
		return false;
	}

	public void prettyPrint() {
		if (parsed) {
			exp.prettyPrint();
			if (otherexp != null)
				otherexp.prettyPrint();
		} else
			System.out.println("Check the syntax first");
	}

}