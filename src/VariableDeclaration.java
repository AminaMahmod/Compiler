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
		if (type.parse() == true) {
			if (id.parse() == true) {
				if (Main.code.get(Main.index).get(1).equals(";")) {
					Main.index++;
					if(var.parse()==true){
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
			var.prettyPrint();
		}
		else
			System.out.println(" ");
	}
	
}