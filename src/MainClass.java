public class MainClass {
	private Identifier className = new Identifier();
	private Identifier args = new Identifier();
	private Statement stmt = new Statement() ;
	private boolean parsed = false;
	
	public MainClass() {
		super();
	}
	
	public MainClass(Identifier className, Identifier args, Statement stmt) {
		super();
		this.className = className;
		this.args = args;
		this.stmt = stmt;
	}

	public boolean parse() {
		System.out.println("Main class");
		if (Main.code.get(Main.index).get(1).equals("class")) {
			className = new Identifier();
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
													args = new Identifier() ;
													if (args.parse() == true) {
														if (Main.code.get(Main.index).get(1).equals(")")) {
															Main.index++;
															if (Main.code.get(Main.index).get(1).equals("{")) {
																Main.index++;
																stmt = new Statement();
																if (stmt.parse() == true) {
																	if (Main.code.get(Main.index).get(1).equals("}")) {
																		Main.index++;
																		if (Main.code.get(Main.index).get(1)
																				.equals("}")) {
																			Main.index++;
																			if(Main.code.get(Main.index).get(0).equals("< EOF >"))
																			{
																				parsed = true;
																				return true;
																			}
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
					}
				}
			}
		}
		return false;
	}

	// "class" Identifier "{" "public" "static" "void"
	// "main" "(" "String" "[" "]" Identifier ")" "{" Statement "}" "}"
	public void prettyPrint() {
		if(parsed)
		{
			System.out.print("class ");
			className.prettyPrint() ;
			Main.tabsCounter ++;
			System.out.print("\n{\n" + Main.printTabs(Main.tabsCounter) +"public static void main ( String" + "[] ");
			args.prettyPrint();
			System.out.println( ")\n");
			System.out.println( Main.printTabs(Main.tabsCounter)+"{");
			Main.tabsCounter++;
			System.out.println(Main.printTabs(Main.tabsCounter) );
			stmt.prettyPrint(); 
			Main.tabsCounter--;
			System.out.print(Main.printTabs(Main.tabsCounter) );
			System.out.println("}");
			Main.tabsCounter --;
			System.out.print(Main.printTabs(Main.tabsCounter) );
			System.out.println("\n}");
		}
		//else 
			//System.out.println("Check the syntax first");
	}
}
