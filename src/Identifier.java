public class Identifier 
{
	private String id ;

	public Identifier() {
		super();
	}
	
	public Identifier(String id) {
		super();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public boolean parse()
	{
		System.out.println("id");
		if (Main.code.get(Main.index).get(0).equals("<ID>"))
		{
			id = Main.code.get(Main.index).get(1);
			Main.index++;
			return true;
		}
		return false; 
	}

	public void prettyPrint() {
		
		System.out.print(id);
	}

}
