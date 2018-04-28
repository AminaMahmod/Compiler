public class ArrayPart {

	private boolean parsed = false;
	
	public void prettyPrint() {
		if (parsed)
			System.out.print("[]");
		else
			System.out.println("Check the syntax first");
	}

	public boolean parse() {
		System.out.println("arr part");
		if (Main.code.get(Main.index).get(1).equals("["))
		{
			Main.index ++ ;
			if (Main.code.get(Main.index).get(1).equals("]"))
			{
				Main.index ++ ;
				parsed = true;
				return true; 
			}
			
		}
		
		return false;
	}

}
