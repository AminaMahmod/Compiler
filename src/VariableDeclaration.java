public class VariableDeclaration {
	private Type type;
	private  Identifier id;
	private  VariableDeclaration var;

	public VariableDeclaration(Type type, Identifier id, VariableDeclaration var) {
		super();
		this.type = type;
		this.id = id;
		this.var=var;
	}

	public boolean parse() {
		System.out.println("var declaration");
		if (type.parse() == true) {
			if (id.parse() == true) {
				if (Main.code.get(Main.index).get(1).equals(";")) {
					Main.index++;
					if(var.parse()==true || var == null){
						return true;
					}
				}
			}
		}
		return false ;
	}
	
	public void prettyPrint()
	{
		if(type != null){
			type.prettyPrint();
			id.prettyPrint();
			System.out.println(";");
			if(var != null)
				var.prettyPrint();
		}
	}
	
}