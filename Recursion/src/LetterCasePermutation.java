import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	static List<String> res = new ArrayList<String>();
	
	public static void main(String[] args) {
		String inp = "a1B2";
		//solveLetterCasePermutation(inp, "");
		System.out.println(letterCasePermutation(inp));
	}
	
	public static List<String> letterCasePermutation(String s) {
		res.clear();
		solveLetterCasePermutation(s, "");
		return res;
	}
	static void solveLetterCasePermutation(String inp, String out)
	{
		if(inp.length()==0)
		{
			//System.out.println("Permutation: "+out);
			res.add(out);
			return;
		}
		if((inp.charAt(0)>='A' && inp.charAt(0)<='Z') || (inp.charAt(0)>='a' && inp.charAt(0)<='z'))
		{
			solveLetterCasePermutation(inp.substring(1), out+(inp.charAt(0)+"").toLowerCase());
			solveLetterCasePermutation(inp.substring(1), out+(inp.charAt(0)+"").toUpperCase());
		}
		else
			solveLetterCasePermutation(inp.substring(1), out+inp.charAt(0));
	}

}
