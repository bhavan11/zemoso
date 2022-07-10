
public class PermutationWithSpaces {

	public static void main(String[] args) {

		String str = "ABC";
		solve(str, 0, "");
	}
	
	public static void solve(String str, int index, String out)
	{
		if(index==str.length()-1)
		{
			System.out.println(out+str.charAt(index));
			return;
		}
		
		solve(str, index+1, out+str.charAt(index));
		solve(str, index+1, out+str.charAt(index)+" ");
	}

}
