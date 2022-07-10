import java.util.Stack;

public class MaximumAreaOfRectangleInBinaryMatrix {

	public static void main(String[] args) {
		/*char[][] matrix = {
				{'0', '1', '1', '0'},
				{'1', '1', '1', '1'},
				{'1', '1', '1', '1'},
				{'1', '1', '0', '0'}
		};*/
		char[][] matrix = {};
		System.out.println(maximalRectangle(matrix));
	}
	
	public static int maximalRectangle(char[][] matrix) {
		if(matrix.length==0)
			return 0;
			
		int[][] integerMatrix = new int[matrix.length][matrix[0].length];
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix[0].length; j++)
			{
				integerMatrix[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));
			}
        int ans = 0;
        for(int i=0; i<integerMatrix.length; i++)
        {
        	if(i!=0)
        	{
        		for(int j=0; j<integerMatrix[i].length; j++)
        		{
        			if(integerMatrix[i][j]!=0)
        				integerMatrix[i][j]=(integerMatrix[i-1][j]+1);
        		}
        	}
        	ans = Math.max(ans, solve(integerMatrix[i]));
        }
        return ans;
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
