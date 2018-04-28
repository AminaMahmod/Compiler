public class BodyStatement {

	private Statement stmt;
	private BodyStatement bodystmt;
	private boolean parsed = false; 
	
	public BodyStatement(Statement stmt ,BodyStatement bodystmt){
		this.stmt = stmt;
		this.bodystmt = bodystmt;
	}
	
	public BodyStatement() {
	}

	public boolean parse() {
		System.out.println("body stmt");
		if (Main.code.get(Main.index).get(1).equals("{"))
			stmt = new Statement();
		else if (Main.code.get(Main.index).get(1).equals("if"))
			stmt = new Statement();
		else if (Main.code.get(Main.index).get(1).equals("while"))
			stmt = new Statement();
		else if (Main.code.get(Main.index).get(1).equals("System.out.println"))
			stmt = new Statement();
		else if (Main.code.get(Main.index).get(0).equals("< ID >"))
			stmt = new Statement();
		
		 if(stmt.parse()){
			 if (Main.code.get(Main.index).get(1).equals("{") ||
						Main.code.get(Main.index).get(1).equals("if")||
						Main.code.get(Main.index).get(1).equals("while")||
						Main.code.get(Main.index).get(1).equals("System.out.println")||
						Main.code.get(Main.index).get(0).equals("< ID >")
				)
				 bodystmt = new BodyStatement();
			 if( bodystmt == null || bodystmt.parse() )
			 {
				 parsed = true;
				 return true;
			 }
		 }
		return false;
	}

	public void prettyPrint() {
		if(parsed)
		{
			if(stmt != null)
			{
				stmt.prettyPrint();
				if (bodystmt != null)
					bodystmt.prettyPrint();
			}
		}
		System.out.println("Check the syntax first");
	}

}
