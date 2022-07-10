import java.util.ArrayList;
import java.util.List;

public class GenerateAllBalancedParenthesis {
	
	static List<String> res = new ArrayList<String>();
	
	public static void main(String[] args) {

		int n=3;
		System.out.println(solveGenerateAllBalancedParenthesis(n));
	}

	public static List<String> solveGenerateAllBalancedParenthesis(int n)
	{	
		res.clear();
		solve(n, 0, 0, "");
		return res;
	}
	
	public static void solve(int n, int started, int ended, String out)
	{
		if(started == n && ended == n)
		{
			//System.out.println("Set: "+out);
			res.add(out);
			return;
		}
		
		//Start an opening bracket
		if(started<n)
			solve(n, started+1, ended, out+"(");
		//End a bracket
		if(ended<n && ended<started)
			solve(n, started, ended+1, out+")");
	}
}
