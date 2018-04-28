import java.util.ArrayList;

public class NewPart {

	private Expression exp;
	private Identifier id;
	private NewExpression newexp;
	private String dataType;
	private static ArrayList<String> types = new ArrayList<>();
	private boolean parsed = false ;

	NewPart() {
		types.add("< STRING >");
		types.add("< BOOLEAN >");
		types.add("< INT >");
		types.add("< CHARACTER >");
		types.add("< FLOAT >");
		types.add("< VOID >");

	}
//DataType "[" Expression "]" |
//Identifier "(" NewExpression ")"
	public boolean parse() {
		id = new Identifier();
		//newexp = new NewExpression() ;
		System.out.println("New Part");
		if (types.contains(Main.code.get(Main.index).get(0))) {
			
			dataType = Main.code.get(Main.index).get(1);
			Main.index++;
			if (Main.code.get(Main.index).get(1).equals("[")) {
				Main.index++;
				if (exp.parse() == true) {
					if (Main.code.get(Main.index).get(1).equals("]")) {
						Main.index++;
						parsed = true ;
						return true;
						
					}
				}
			}
		} else if (id.parse() == true) {
			if (Main.code.get(Main.index).get(1).equals("(")) {
				Main.index++;
				if(!Main.code.get(Main.index).get(1).equals(")"))
					newexp = new NewExpression() ;
				if ( newexp == null || newexp.parse()) {
					
					if (Main.code.get(Main.index).get(1).equals(")")) {
						Main.index++;
						parsed = true;
						return true;
					}
				}
			}
		}
		return false;
	}

	public void prettyPrint() {

		if (parsed)
		{
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
}
