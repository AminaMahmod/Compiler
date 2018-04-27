public class Parameters {

	private Type type;
	private  Identifier id;
	private  OtherParameters othpar;
	
	public Parameters ( Type type,Identifier id ,OtherParameters othpar) {
		super();
		this.type=type;
		this.id=id;
		this.othpar =othpar;
	}

	public boolean parse() {
		System.out.println("param");
		if(type.parse() == true){
			if(id.parse() == true){
				if(othpar.parse() == true || othpar == null){
					return true;
				}
			}
		}
		return false;
	}

	public void prettyPrint() {
		if(type != null){
			type.prettyPrint();
			id.prettyPrint();
			if (othpar != null)
				othpar.prettyPrint();
		}
		else
			System.out.print(" ");
	}


}
