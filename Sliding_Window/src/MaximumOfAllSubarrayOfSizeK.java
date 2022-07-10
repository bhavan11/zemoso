import java.util.ArrayList;
import java.util.List;

public class MaximumOfAllSubarrayOfSizeK {

	public static void main(String[] args) {

		//int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
		//int k = 3;//[3, 3, 5, 5, 6, 7]
		//int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		//int k = 3;//3, 3, 4, 5, 5, 5, 6
		int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int k = 4;//10, 10, 10, 15, 15, 90, 90
		System.out.println(solveMaximumOfAllSubarrayOfSizeK(arr, k));
	}
	
	public static List<Integer> solveMaximumOfAllSubarrayOfSizeK(int[] arr, int k)
	{
		List<Integer> res = new ArrayList<Integer>();
		int[] ans = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
		for(int i=0; i<k; i++)
		{
			if(ans[1]<arr[i])
			{
				ans[0]=i;
				ans[1]=arr[i];
			}
		}
		res.add(ans[1]);
		
		for(int i=k; i<arr.length; i++)
		{
			int indexRemoved = i-k;
			if(ans[0]==indexRemoved)//The removed element is max
			{
				if(arr[i]>=ans[1])
				{
					ans[0]=i;
					ans[1]=arr[i];
				}
				else //arr[i]<ans[1];
				{
					//Check all Elements
					ans[1]=Integer.MIN_VALUE;
					for(int j=indexRemoved+1; j<=i; j++)
					{
						if(ans[1]<arr[j])
						{
							ans[0]=j;
							ans[1]=arr[j];
						}
					}
					
				}
			}
			else//ans[0]!=indexRemoved i.e the removed element is not max
			{
				if(arr[i]>ans[1])
				{
					ans[0]=i;
					ans[1]=arr[i];
				}
				//else //arr[i]<=ans[1]
			}
			res.add(ans[1]);
		}
		
		return res;
	}

}
