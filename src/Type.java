import java.util.ArrayList;

public class Type 
{
	private String dataType ;
	private ArrayPart arrPart ;
	private static ArrayList<String> types = new ArrayList<>();
	
	
	Type()
	{
		types.add("<STRING>");
		types.add("<BOOLEAN>");
		types.add("<INT>");
		types.add("<CHARACTER>");
		types.add("<FLOAT>");
		
	}
	

	public void prettyPrint()
	{
		System.out.print(dataType);
		arrPart.prettyPrint();
	}
	
	public boolean parse()
	{
		if (types.contains(Main.code.get(Main.index).get(0)))
		{
			Main.index ++ ;
			if  (arrPart.parse() || arrPart == null)
			{
				return true;
			}
		}
		return false;
	}
}
