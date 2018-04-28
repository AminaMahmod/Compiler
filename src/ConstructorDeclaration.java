public class ConstructorDeclaration {

	private Identifier id;
	private Parameters par;
	private Body body;
	private ConstructorDeclaration cons;
	private boolean parsed = false;

	public ConstructorDeclaration(Identifier id, Parameters par, Body body, ConstructorDeclaration cons) {
		super();
		this.id = id;
		this.par = par;
		this.body = body;
		this.cons = cons;
	}

	public ConstructorDeclaration() {
	}

	public boolean parse() {
		System.out.println("constructor");
		if (Main.code.get(Main.index).get(0).equals("< ID >")) 
		{
			id = new Identifier();
			par = new Parameters();
			body = new Body();
			if (id.parse() == true) {
				if (Main.code.get(Main.index).get(1).equals("("))
				{
					Main.index++;
					if (par.parse() == true) {
						if (Main.code.get(Main.index).get(1).equals(")"))
						{
							Main.index++;
							if (Main.code.get(Main.index).get(1).equals("{")) 
							{
								Main.index++;
								if (body.parse() == true) 
								{
									if (Main.code.get(Main.index).get(1).equals("}")) 
									{
										Main.index++;
										if (Main.code.get(Main.index).get(0).equals("< ID >"))
											cons = new ConstructorDeclaration();
										if (cons == null || cons.parse()) 
										{
											parsed = true;
											return true;
										}
									}
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
		if (parsed) {
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
		} else
			System.out.println("Check the syntax first");
	}

}