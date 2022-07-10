
public class PrintNDigitBinaryWithNumberOf1sGreaterThanEqualToNumberOf0s {

	public static void main(String[] args) {

		int n = 4;
		solvePrintNDigitBinaryWithNumberOf1sGreaterThanEqualToNumberOf0s(n);
	}
	
	static void solvePrintNDigitBinaryWithNumberOf1sGreaterThanEqualToNumberOf0s(int n)
	{
		solve(n, 0, 0, "");
	}
	
	public static void solve(int n, int noOne, int noZero, String out)
	{
		if(noOne+noZero==n)
		{
			System.out.println("Binary num: "+out);
			return;
		}
		//Adding 1
		solve(n, noOne+1, noZero, out+"1");
		//Adding 0
		if(noZero<noOne)
			solve(n, noOne, noZero+1, out+"0");
	}

}
