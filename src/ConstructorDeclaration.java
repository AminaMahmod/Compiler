public class ConstructorDeclaration {

	private Identifier id;
	private Parameters par;
	private Body body;

	public ConstructorDeclaration(Identifier id, Parameters par, Body body) {
		super();
		this.id = id;
		this.par = par;
		this.body = body;
	}

	public boolean parse() {
		if (id.parse() == true) {
			if (Main.code.get(Main.index).get(1).equals("(")) {
				Main.index++;
				if (par.parse() == true) {
					if (Main.code.get(Main.index).get(1).equals(")")) {
						Main.index++;
						if (Main.code.get(Main.index).get(1).equals("{")) {
							Main.index++;
							if (body.parse() == true) {
								if (Main.code.get(Main.index).get(1).equals("}")) {
									Main.index++;
									return true;
								}
							}
						}

					}
				}
			}
		}
		return false;
	}

	public void prettyPrint() {
		if (id != null) {
			id.prettyPrint();
			System.out.println("(");
			par.prettyPrint();
			System.out.println(")");
			System.out.println("{");
			body.prettyPrint();
			System.out.println("}");

		}
		else
			System.out.println(" ");
	}

	
}