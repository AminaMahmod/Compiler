import java.util.ArrayList;

public class Type 
{
	private String dataType ;
	private ArrayPart arrPart ;
	private static ArrayList<String> types = new ArrayList<>();
	
	
	public Type(String dataType, ArrayPart arrPart) {
		super();
		this.dataType = dataType;
		this.arrPart = arrPart;
		types.add("<STRING>");
		types.add("<BOOLEAN>");
		types.add("<INT>");
		types.add("<CHARACTER>");
		types.add("<FLOAT>");
	}


	public Type()
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
		if (arrPart != null)
			arrPart.prettyPrint();
	}
	
	public boolean parse()
	{
		if (types.contains(Main.code.get(Main.index).get(0)))
		{
			dataType = Main.code.get(Main.index).get(1);
			Main.index ++ ;
			if  (arrPart.parse() || arrPart == null)
			{
				return true;
			}
		}
		return false;
	}
}
