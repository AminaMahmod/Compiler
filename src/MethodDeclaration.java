public class MethodDeclaration {

	private AccessModifier acsss;
	private Type type;
	private Identifier id;
	private Parameters par;
	private Body body;
	private Expression exp;
	private MethodDeclaration method;

	public MethodDeclaration(AccessModifier acsss, Type type, Identifier id, Parameters par, Body body,
			Expression exp , MethodDeclaration method) {

		this.acsss = acsss;
		this.type = type;
		this.id = id;
		this.par = par;
		this.body = body;
		this.exp = exp;
		this.method = method;
	}

	public boolean parse() {
		if (acsss.parse() == true) {
			if (type.parse() == true) {
				if (id.parse() == true) {
					if (Main.code.get(Main.index).get(1).equals("(")) {
						Main.index++;
						if (par.parse() == true) {
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
														if (method.parse() || method==null)
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
		return false;
	}

	public void prettyPrint() {
		if (acsss != null) {
			acsss.prettyPrint();
			type.prettyPrint();
			id.prettyPrint();
			System.out.println("(");
			par.prettyPrint();
			System.out.println(")");
			System.out.println("{");
			body.prettyPrint();
			System.out.println("return");
			exp.prettyPrint();
			System.out.println(";");
			System.out.println("}");
			if (method !=null)
				method.prettyPrint();
		}
		
	}

}