import java.util.ArrayList;

public class NewPart {

	private Expression exp;
	private Identifier id;
	private NewExpression newexp;
	private String dataType;
	private static ArrayList<String> types = new ArrayList<>();

	NewPart() {
		types.add("<STRING>");
		types.add("<BOOLEAN>");
		types.add("<INT>");
		types.add("<CHARACTER>");
		types.add("<FLOAT>");

	}

	public boolean parse() {
		if (types.contains(Main.code.get(Main.index).get(1))) {
			Main.index++;
			if (Main.code.get(Main.index).get(1).equals("[")) {
				Main.index++;
				if (exp.parse() == true) {
					if (Main.code.get(Main.index).get(1).equals("]")) {
						Main.index++;
						return true;
						
					}
				}
			}
		} else if (id.parse() == true) {
			if (Main.code.get(Main.index).get(1).equals("(")) {
				Main.index++;
				if (newexp.parse() == true) {
					if (Main.code.get(Main.index).get(1).equals(")")) {
						Main.index++;
						return true;
					}
				}
			}
		}
		return false;
	}

	public void prettyPrint() {

		if(exp!=null)
		{
			System.out.println(dataType);
			System.out.println("[");
			exp.prettyPrint();
			System.out.println("]");
		}
		else if(newexp!=null)
		{
			id.prettyPrint();
			System.out.println("(");
			newexp.prettyPrint();
			System.out.println(")");
		}		
	}
}
