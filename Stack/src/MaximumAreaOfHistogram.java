import java.util.Stack;

public class MaximumAreaOfHistogram {

	public static void main(String[] args) {
		//int[] arr = {6, 2, 5, 4, 5, 1, 6};
		int[] arr = {2, 1, 5, 6, 2, 3};
		System.out.println(solve(arr));
	}
	
	public static int solve(int[] arr)
	{
		Stack<int[]> stack = new Stack<int[]>();
		int[] nsl = new int[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			int count=1;
			while(!stack.isEmpty() && stack.peek()[0]>=arr[i])
			{
				count = count + stack.pop()[1];
			}
			stack.push(new int[] {arr[i], count});
			nsl[i] = count;
		}
		
		stack.clear();
		int[] nsr = new int[arr.length];
		for(int i=arr.length-1; i>=0; i--)
		{
			int count=1;
			while(!stack.isEmpty() && stack.peek()[0]>=arr[i])
			{
				count = count + stack.pop()[1];
			}
			stack.push(new int[] {arr[i], count});
			nsr[i] = count-1;
		}
		
		int ans=0;
		for(int i=0; i<arr.length; i++)
		{
			ans = Math.max(ans, arr[i]*(nsl[i]+nsr[i]));
		}
		return ans;
	}

}
