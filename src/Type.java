import java.util.ArrayList;

public class Type 
{
	private String dataType ;
	private ArrayPart arrPart ;
	private static ArrayList<String> types = new ArrayList<>();
	private boolean parsed = false;
	
	public Type(String dataType, ArrayPart arrPart) {
		super();
		this.dataType = dataType;
		this.arrPart = arrPart;
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");
	}


	public Type()
	{
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");
		
	}
	

	public void prettyPrint()
	{
		if (parsed)
		{
			System.out.print(dataType+" ");
			if (arrPart != null)
				arrPart.prettyPrint();
		}
		else
		{
			//System.out.println("Check the syntax first");
		}
	}
	
	public boolean parse()
	{
		System.out.println("type");
		if (types.contains(Main.code.get(Main.index).get(0)))
		{
			dataType = Main.code.get(Main.index).get(1);
			Main.index ++ ;
			if (Main.code.get(Main.index).get(1).equals("["))
				arrPart = new ArrayPart() ;
			if (arrPart == null||arrPart.parse() )
			{
				parsed = true;
				return true;
			}
		}
		return false;
	}
}
