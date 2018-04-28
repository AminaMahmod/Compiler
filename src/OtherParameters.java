public class OtherParameters {
	
	private Parameters par;
	private boolean parsed = false ;

	public OtherParameters(Parameters par) {
		this.par = par;

	}

	public OtherParameters() 
	{
	}

	public boolean parse() {
		System.out.println("other param");
		if (Main.code.get(Main.index).get(1).equals(",")) 
		{
			Main.index++;
			par = new Parameters();
			if (par.parse() == true) {
				parsed = true;
				return true;
			}
		}
		return false;
	}

	public void prettyPrint() {
		if (parsed)
		{	
			if (par != null) {
				System.out.println(" , ");
				par.prettyPrint();
			}
		}
		else
		{
			System.out.println("Check the syntax first");
		}
	}

}