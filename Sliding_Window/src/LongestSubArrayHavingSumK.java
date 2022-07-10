
public class LongestSubArrayHavingSumK {

	public static void main(String[] args) {

		//int arr[] = { 10, 5, 2, 7, 1, 9 };
		//int k = 15;
		//int arr[] = {4, 1, 1, 1, 2, 3, 5};
		//int k = 5;
		int arr[] = {1, 2, 3, 7, 5};
		int k = 12;
		
		System.out.println(solveLongestSubArrayHavingSumK(arr, k));
	}
	
	public static int solveLongestSubArrayHavingSumK(int[] arr, int k)
	{
		int start = 0;
		int count = 0;
		int sum = 0;
		int maxCount = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++)
		{
			sum += arr[i];
			count++;
			if(sum>=k)
			{
				while(sum>k)
				{
					sum -= arr[start++];
					count--;
				}
				if(sum==k)
				{
					maxCount = Math.max(maxCount, count);
					sum -= arr[start++];
					count--;
				}
			}
		}
		
		return maxCount;
	}

}
