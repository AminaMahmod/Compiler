
public class ClassBody {
	public VariableDeclaration var;
	public ConstructorDeclaration cons;
	public MethodDeclaration method;

	public void prettyPrint() {
		var.prettyPrint();
		cons.prettyPrint();
		method.prettyPrint();
	}

	public boolean parse() {
		if (Main.code.get(Main.index).get(1).equals("{")) {
			Main.index++;
			if (var.parse() == true && cons.parse() == true && method.parse()) {

				if (Main.code.get(Main.index).get(1).equals("}")) {
					Main.index++;
					return true;
				}
			}
		}

		return false;
	}

}
