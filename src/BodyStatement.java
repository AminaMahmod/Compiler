public class BodyStatement {

	private Statement stmt;
	private BodyStatement bodystmt;
	
	public BodyStatement(Statement stmt ,BodyStatement bodystmt){
		this.stmt = stmt;
		this.bodystmt = bodystmt;
	}
	
	public boolean parse() {
		 if(stmt.parse() == true){
			 if(bodystmt.parse() == true)
				 return true;
		 }
		return false;
	}

	public void prettyPrint() {
		if(stmt != null){
			stmt.prettyPrint();
			bodystmt.prettyPrint();
		}
		else
			System.out.println(" ");
	}

}
