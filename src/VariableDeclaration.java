import java.util.ArrayList;

public class VariableDeclaration {
	private Type type;
	private  Identifier id;
	private  VariableDeclaration var;
	private boolean parsed = false;
	private static ArrayList<String> types = new ArrayList<>();

	public VariableDeclaration(Type type, Identifier id, VariableDeclaration var) {
		super();
		this.type = type;
		this.id = id;
		this.var=var;
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");
	}

	public VariableDeclaration() {
		super();
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");
	}

	public boolean parse() {
		
		System.out.println("var declaration");
		type=new Type();
		if (type.parse()) {
			id = new Identifier() ;
			if (id.parse()) {
				if (Main.code.get(Main.index).get(1).equals(";")) {
					Main.index++;
					if (types.contains(Main.code.get(Main.index).get(0)))
						var = new VariableDeclaration() ;
					if(var == null||var.parse()==true ){
						parsed = true;
						return true;
					}
				}
			}
		}
		return false ;
	}
	
	public void prettyPrint()
	{
		if (parsed)
		{
			if(type != null){
				System.out.print(Main.printTabs(Main.tabsCounter));
				type.prettyPrint();
				id.prettyPrint();
				System.out.println(";\n");
				if(var != null)
					var.prettyPrint();
			}
		}
		else
		{
			//System.out.println("Check the syntax first");
		}
	}
	
}