import java.util.ArrayList;

public class MethodDeclaration {

	private AccessModifier acsss = new AccessModifier();
	private Type type = new Type();
	private Identifier id = new Identifier();
	private Parameters par ;
	private Body body = new Body();
	private Expression exp = new Expression();
	private MethodDeclaration method;
	private boolean parsed = false;
	private static ArrayList<String> types = new ArrayList<>();
	
	public MethodDeclaration(AccessModifier acsss, Type type, Identifier id, Parameters par, Body body,
			Expression exp , MethodDeclaration method) {

		this.acsss = acsss;
		this.type = type;
		this.id = id;
		this.par = par;
		this.body = body;
		this.exp = exp;
		this.method = method;
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");
	}

	public MethodDeclaration() {
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");
	}

	public boolean parse() {
		System.out.println("Method");
		if (acsss.parse() == true) {
			if (type.parse() == true) {
				if (id.parse() == true) {
					if (Main.code.get(Main.index).get(1).equals("(")) {
						Main.index++;
						if (types.contains(Main.code.get(Main.index).get(0)))
							par = new Parameters() ;
						if (par == null || par.parse() == true) {
							if (Main.code.get(Main.index).get(1).equals(")")) {
								Main.index++;
								if (Main.code.get(Main.index).get(1).equals("{")) {
									Main.index++;
									if (body.parse() == true) {
										if (Main.code.get(Main.index).get(1).equals("return")) {
											Main.index++;
											if (exp.parse() == true) {
												if (Main.code.get(Main.index).get(1).equals(";")) {
													Main.index++;
													if (Main.code.get(Main.index).get(1).equals("}")) {
														Main.index++;
														if (Main.code.get(Main.index).get(1).equals("public")
																|| Main.code.get(Main.index).get(1).equals("private")
																|| Main.code.get(Main.index).get(1).equals("protected"))
															method = new MethodDeclaration();

														if ( method==null || method.parse() )
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
					}

				}
			}

		}
		return false;
	}

	public void prettyPrint() {
		if(parsed)
		{
			if (acsss != null)
			{
				acsss.prettyPrint();
				type.prettyPrint();
				id.prettyPrint();
				System.out.println(" ( ");
				par.prettyPrint();
				System.out.println(" ) ");
				System.out.println("{\n");
				Main.tabsCounter++;
				System.out.print(Main.printTabs(Main.tabsCounter) );
				body.prettyPrint();
				System.out.print(Main.printTabs(Main.tabsCounter) );
				System.out.println("\nreturn");
				exp.prettyPrint();
				System.out.println(" ;");
				Main.tabsCounter--;
				System.out.print(Main.printTabs(Main.tabsCounter) );
				System.out.println("\n}");
				if (method !=null)
					method.prettyPrint();
			}
		}
		else 
			System.out.println("Check the syntax first");
	}

}