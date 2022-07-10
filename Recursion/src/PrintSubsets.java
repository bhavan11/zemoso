
public class PrintSubsets {

	public static void main(String[] args) {

		//String inp = "abc";
		String inp = "aab";
		solve(inp, "");
	}
	
	public static void solve(String inp, String out)
	{
		if(inp.length()==0)
		{
			System.out.println("subset: "+out);
			return;
		}
		
		solve(inp.substring(1), out+inp.charAt(0));
		solve(inp.substring(1), out);
	}

}
