public class Body {

	private VariableDeclaration var;
	private BodyStatement bodystmt;

	public Body(VariableDeclaration var, BodyStatement bodystmt) {
		this.bodystmt = bodystmt;
		this.var = var;
	}

	public boolean parse() {
		System.out.println("body");
		if (var.parse() == true) {
			if (bodystmt.parse() == true) {
				return true;
			}
		}
		return false;
	}

	public void prettyPrint() {
		if(var != null)
			var.prettyPrint();
		if(bodystmt != null)
			bodystmt.prettyPrint();
		else
			System.out.print(" ");
	}

}
