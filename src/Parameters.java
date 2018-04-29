public class Parameters {

	private Type type;
	private  Identifier id;
	private  OtherParameters othpar;
	private boolean parsed = false ;
	
	public Parameters ( Type type,Identifier id ,OtherParameters othpar) {
		super();
		this.type=type;
		this.id=id;
		this.othpar =othpar;
	}

	public Parameters() {
	}

	public boolean parse() {
		System.out.println("param");
		type = new Type();
		if(type.parse() == true){
			id = new Identifier() ;
			if(id.parse() == true){
				if (Main.code.get(Main.index).get(1).equals(","))
					othpar = new OtherParameters( );
				if(othpar == null || othpar.parse() ){
					parsed = true ;
					return true;
				}
			}
		}
		return false;
	}

	public void prettyPrint() {
		if (parsed)
		{
			if(type != null)
			{
				type.prettyPrint();
				id.prettyPrint();
				if (othpar != null)
					othpar.prettyPrint();
			}
		}
		else
		{
			//System.out.println("Check the syntax first");
		}
	}


}
