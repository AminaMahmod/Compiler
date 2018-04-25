public class OtherParameters {
	
	private Parameters par;

	public OtherParameters(Parameters par) {
		this.par = par;

	}

	public boolean parse() {
		if (Main.code.get(Main.index).get(1).equals(",")) {
			Main.index++;
			if (par.parse() == true) {
				return true;
			}
		}
		return false;
	}

	public void prettyPrint() {
		if (par != null) {
			System.out.println(",");
			par.prettyPrint();
		}
		else
			System.out.println(" ");
	}

}