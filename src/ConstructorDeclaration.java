public class ConstructorDeclaration {

	private Identifier id;
	private Parameters par;
	private Body body;
	private ConstructorDeclaration cons; 

	public ConstructorDeclaration(Identifier id, Parameters par, Body body, ConstructorDeclaration cons) {
		super();
		this.id = id;
		this.par = par;
		this.body = body;
		this.cons = cons ;
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
									if (cons.parse() || cons == null)
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
			if (cons != null)
				cons.prettyPrint();
		}
	}

	
}