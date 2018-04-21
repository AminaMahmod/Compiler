public class MainClass {
	private Identifier className;
	private Identifier args;
	private Statement stmt;

	public boolean parse() {
		if (Main.code.get(Main.index).get(1).equals("class")) {
			Main.index++;

			if (className.parse()) {
				if (Main.code.get(Main.index).get(1).equals("{")) {
					Main.index++;

					if (Main.code.get(Main.index).get(1).equals("public")) {
						Main.index++;
						if (Main.code.get(Main.index).get(1).equals("static")) {
							Main.index++;
							if (Main.code.get(Main.index).get(1).equals("void")) {
								Main.index++;
								if (Main.code.get(Main.index).get(1).equals("main")) {
									Main.index++;
									if (Main.code.get(Main.index).get(1).equals("(")) {
										Main.index++;
										if (Main.code.get(Main.index).get(1).equals("String")) {
											Main.index++;
											if (Main.code.get(Main.index).get(1).equals("[")) {
												Main.index++;
												if (Main.code.get(Main.index).get(1).equals("]")) {
													Main.index++;
													if (args.parse() == true) {
														if (Main.code.get(Main.index).get(1).equals("0")) {
															Main.index++;
															if (Main.code.get(Main.index).get(1).equals("{")) {
																Main.index++;
																if (stmt.parse() == true) {
																	if (Main.code.get(Main.index).get(1).equals("}")) {
																		Main.index++;
																		if (Main.code.get(Main.index).get(1)
																				.equals("}")) {
																			Main.index++;
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
					}
				}
			}
		} else {
			return false;
		}
		return false;
	}

	// "class" Identifier "{" "public" "static" "void"
	// "main" "(" "String" "[" "]" Identifier ")" "{" Statement "}" "}"
	public void prettyPrint() {

		System.out.print("class ");
		className.prettyPrint() ;
		System.out.print("\n{\n\tpublic static void main ( String" + "[] ");
		args.prettyPrint();
		System.out.println(")\n\t{\t\t" );
		stmt.prettyPrint(); 
		System.out.println("\n}");
		

	}

}
