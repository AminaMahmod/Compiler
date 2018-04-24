public class Identifier 
{
	String id ;
	
	public Identifier(String id) {
		super();
		this.id = id;
	}

	public boolean parse()
	{
		if (Main.code.get(Main.index).get(0).equals("<IDENTIFIER>"))
		{
			Main.index++;
			return true;
		}
		return false; 
	}

	public void prettyPrint() {
		System.out.print( id);
	}

}
