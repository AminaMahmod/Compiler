public class AccessModifier {

	private String modifier ;
	
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
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("private")){
			Main.index ++;
			modifier = "private" ;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("protected")){
			Main.index ++;
			modifier = "protected" ;
			return true;
		}
		return false;
	}
	
	public void prettyPrint()
	{
		System.out.print(modifier);
	}
}
