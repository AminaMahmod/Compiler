public class AccessModifier {

	private String modifier ;
	private boolean parsed = false;
	
	public AccessModifier() {
		super();
	}

	public AccessModifier(String modifier) {
		super();
		this.modifier = modifier;
	}

	public boolean parse() {
		System.out.println("Access Modifiers");
		if (Main.code.get(Main.index).get(1).equals("public")) {
			Main.index++;
			modifier = "public" ;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("private")){
			Main.index ++;
			modifier = "private" ;
			parsed = true;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("protected")){
			Main.index ++;
			modifier = "protected" ;
			parsed = true;
			return true;
		}
		return false;
	}
	
	public void prettyPrint()
	{
		if (parsed)
			System.out.print(modifier);
		else
			System.out.println("Check the syntax first");
	}
}
