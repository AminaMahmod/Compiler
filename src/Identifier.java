public class Identifier 
{
	private String id ;
	private boolean parsed = false;

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
			parsed = true;
			return true;
		}
		return false; 
	}

	public void prettyPrint() {
		if (parsed)
			System.out.print(id);
		else
			System.out.println("Check the syb=ntax first");
	}

}
