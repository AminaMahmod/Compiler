
public class ExpressionPart {
	// ExpressionPart -> Operator Expression | "[" Expression "]" | "." DotPart
	private Operator op;
	private Expression exp;
	private DotPart dp;
	private boolean parsed = false;

	public boolean initFinalOperator() {
		if (Main.code.get(Main.index).get(1).equals("&&") || Main.code.get(Main.index).get(1).equals("||")
				|| Main.code.get(Main.index).get(1).equals("==") || (Main.code.get(Main.index).get(1).equals("!")&&Main.code.get(Main.index+1).get(1).equals("="))
				|| Main.code.get(Main.index).get(1).equals("+") || Main.code.get(Main.index).get(1).equals("-")
				|| Main.code.get(Main.index).get(1).equals("*") || Main.code.get(Main.index).get(1).equals("/")
				|| Main.code.get(Main.index).get(1).equals(">") || Main.code.get(Main.index).get(1).equals("<")
				|| Main.code.get(Main.index).get(1).equals(">=") || Main.code.get(Main.index).get(1).equals("<="))
				{
			return true;
		}
		return false;
	}

	
	public boolean parse() {
		System.out.println("exp part");

		if (initFinalOperator())
			op = new Operator();
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
			 if (op != null) {
					op.prettyPrint();
					exp.prettyPrint();
				}
			 else if (exp != null) {
					System.out.print("[");
					exp.prettyPrint();
					System.out.print("]");
				}
			else if (dp != null) {
				System.out.print(".");
				dp.prettyPrint();
			}
		}
		//else 
			//System.out.println("Check the syntax first");
	}
}
