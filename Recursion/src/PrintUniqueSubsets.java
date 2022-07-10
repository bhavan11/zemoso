
public class PrintUniqueSubsets {

	public static void main(String[] args) {
		String inp = "abab";
		String out = "";
		solvePrintUniqueSubsets(inp, out);
	}
	
	public static void solvePrintUniqueSubsets(String inp, String out)
	{
		if(inp.length()==0)
		{
			System.out.println("subset: "+out);
			return;
		}
		
		solvePrintUniqueSubsets(inp.substring(1), out+inp.charAt(0));
		if(inp.length()>1)
		{
			while(inp.length()>1 && inp.charAt(0)==inp.charAt(1))
				inp = inp.substring(1);
		}
		solvePrintUniqueSubsets(inp.substring(1), out);
	}

}
