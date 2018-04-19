import java.util.ArrayList;

public class OtherClasses {
	public ClassDeclaration cd;
	public ArrayList<OtherClasses> oc;

	public void prettyPrint() {
		String objectWords = "";
		for (int i = 0; i < oc.size(); i++) {
			objectWords += oc.get(i);
		}
		cd.prettyPrint();
		System.out.println(objectWords);
	}

	public boolean parse() {
		if (cd.parse() == true) {
			if (cd.parse() == true) {
				return false;
			}
		} else if (cd==null) {
			return true;
		} else {
			return false;
		}
		return false;
	}

}
