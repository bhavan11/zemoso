import java.util.ArrayList;
import java.util.List;

public class MaximumMinimumSumOfSubArrayOfSizeK {

	public static void main(String[] args) {

		int[] arr = {100, 200, 300, 400};
		int k = 2;
		System.out.println(solve(arr, k));
	}

	public static List<Integer> solve(int[] arr, int k)
	{
		int sum = 0;
		int maxSum = 0;
		int minSum = 0;
		for(int i=0; i<k; i++)
			sum += arr[i];
		maxSum = sum;
		minSum = sum;
		
		for(int i = k; i<arr.length; i++)
		{
			sum += arr[i] - arr[i-k];
			maxSum = Math.max(sum, maxSum);
			minSum = Math.min(sum, minSum);
		}
		
		List<Integer> res = new ArrayList<Integer>();
		res.add(maxSum);
		res.add(minSum);
		
		return res;
	}
}
