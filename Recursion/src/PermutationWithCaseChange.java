
public class PermutationWithCaseChange {

	public static void main(String[] args) {

		String inp = "ab";
		solvePermutationWithCaseChange(inp, "");
	}

	private static void solvePermutationWithCaseChange(String inp, String out) {
		if(inp.length()==0)
		{
			System.out.println("Permutation: "+out);
			return;
		}
		String temp = inp.charAt(0)+"";
		temp = temp.toUpperCase();
		solvePermutationWithCaseChange(inp.substring(1), out+temp);
		temp = temp.toLowerCase();
		solvePermutationWithCaseChange(inp.substring(1), out+temp);
		
	}

}
