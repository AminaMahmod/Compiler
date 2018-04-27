public class BodyStatement {

	private Statement stmt;
	private BodyStatement bodystmt;
	
	public BodyStatement(Statement stmt ,BodyStatement bodystmt){
		this.stmt = stmt;
		this.bodystmt = bodystmt;
	}
	
	public boolean parse() {
		System.out.println("body stmt");
		 if(stmt.parse() == true){
			 if(bodystmt.parse() == true || bodystmt == null )
				 return true;
		 }
		return false;
	}

	public void prettyPrint() {
		if(stmt != null){
			stmt.prettyPrint();
			if (bodystmt != null)
				bodystmt.prettyPrint();
		}
		else
			System.out.print(" ");
	}

}
