import java.util.ArrayList;

public class OtherClasses {
	public ClassDeclaration cd = new ClassDeclaration();
	public ArrayList<OtherClasses> oc;

	public void prettyPrint() {
		String objectWords = "";
		for (int i = 0; i < oc.size(); i++) {
			objectWords += oc.get(i);
		}
		cd.prettyPrint();
		System.out.println(objectWords);
	}

	public OtherClasses parse()
	{
		if (cd.parse() == true) 
		{
			if (cd.parse() == true) 
			{
				return null;
			}
		} 
		else if (cd==null)
		{
			return this;
		}
		return null;
	}

}
