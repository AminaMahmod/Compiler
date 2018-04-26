public class AccessModifier {

	// constructor ??	

	
	public boolean pares() {
		if (Main.code.get(Main.index).get(1).equals("public")) {
			Main.index++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("private")){
			Main.index ++;
			return true;
		}
		else if(Main.code.get(Main.index).get(1).equals("protected")){
			Main.index ++;
			return true;
		}
		return false;
	}
	
	public void prettyPrint()
	{
	// print Whaaaaaaaaaaaaaat ??	
	}
}
