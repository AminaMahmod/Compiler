import java.util.ArrayList;

public class ConstructorDeclaration {

	private Identifier id;
	private Parameters par;
	private Body body;
	private ConstructorDeclaration cons;
	private boolean parsed = false;
	private static ArrayList<String> types = new ArrayList<>();

	public ConstructorDeclaration(Identifier id, Parameters par, Body body, ConstructorDeclaration cons) {
		super();
		this.id = id;
		this.par = par;
		this.body = body;
		this.cons = cons;
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");
	}

	public ConstructorDeclaration() {
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");
	}

	public boolean parse() {
		System.out.println("constructor");
		if (Main.code.get(Main.index).get(0).equals("< ID >")) 
		{
			id = new Identifier();
			body = new Body();
			if (id.parse() == true) {
				if (Main.code.get(Main.index).get(1).equals("("))
				{
					Main.index++;
					if (types.contains(Main.code.get(Main.index).get(0)))
						par = new Parameters();
					if (par == null || par.parse() == true) {
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
				System.out.println(" ( ");
				par.prettyPrint();
				System.out.println(" ) ");
				Main.tabsCounter ++;
				System.out.println("{");
				System.out.println(Main.printTabs(Main.tabsCounter));
				body.prettyPrint();
				Main.tabsCounter --;
				System.out.println(Main.printTabs(Main.tabsCounter));
				System.out.println("}");
				if (cons != null)
					cons.prettyPrint();
			}
		} else
			System.out.println("Check the syntax first");
	}

}