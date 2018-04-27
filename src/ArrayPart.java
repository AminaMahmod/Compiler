
public class ArrayPart {

	public void prettyPrint() {
		System.out.print("[]");
		
	}

	public boolean parse() {
		System.out.println("arr part");
		if (Main.code.get(Main.index).get(1).equals("["))
		{
			Main.index ++ ;
			if (Main.code.get(Main.index).get(1).equals("]"))
			{
				Main.index ++ ;
				return true; 
			}
			
		}
		
		return false;
	}

}
