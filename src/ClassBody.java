import java.util.ArrayList;

public class ClassBody {
	public VariableDeclaration var;
	public ConstructorDeclaration cons;
	public MethodDeclaration method;
	private boolean parsed = false;
	private static ArrayList<String> types = new ArrayList<>();

	public ClassBody() {
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");

	}

	public void prettyPrint() {
		if (parsed) {
			System.out.println("\n{\n");
			var.prettyPrint();
			cons.prettyPrint();
			method.prettyPrint();
			System.out.println("\n}\n");

		} else
			System.out.println("Check the syntax first");
	}

	public boolean parse() {
		//System.out.println("class body");
		if (Main.code.get(Main.index).get(1).equals("{")) {
			Main.index++;
			if (types.contains(Main.code.get(Main.index).get(0)))
				var = new VariableDeclaration();
			if (var == null || var.parse() == true) {
				if (Main.code.get(Main.index).get(0).equals("< ID >"))
					cons = new ConstructorDeclaration();
				if (cons == null || cons.parse() == true) {
					if (Main.code.get(Main.index).get(1).equals("public")
							|| Main.code.get(Main.index).get(1).equals("private")
							|| Main.code.get(Main.index).get(1).equals("protected"))
						method = new MethodDeclaration();

					if (method == null || method.parse()) {
						if (Main.code.get(Main.index).get(1).equals("}")) {
							parsed = true;
							Main.index++;
							return true;
						}
					}
				}
			}
		}

		return false;
	}

}