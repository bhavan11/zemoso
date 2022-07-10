import java.util.ArrayList;
import java.util.List;

public class FirstNegativeIntegerInEveryWindowOfSizeK {

	public static void main(String[] args) {

		//int[] arr = {-8, 2, 3, -6, 10};
		//int k = 2;//-8, 0, -6, -6
		//int[] arr = {12, -1, -7, 8, -15, 30, 13, 28};
		//int k = 3;//-1, -1, -7, -15, -15, 0
		int[] arr = {48, 974, 5, -59, -451};
		int k = 3;//
		System.out.println(solve(arr, k));
	}
	
	public static List<Integer> solve(int[] arr, int k)
	{
		List<Integer> res = new ArrayList<Integer>();
		int negNum = 0;
		for(int i=0; i<k; i++)
		{
			if(arr[i]<0)
			{
				negNum = arr[i];
				break;
			}
		}
		res.add(negNum);
		
		for(int i=k; i<arr.length; i++)
		{
			if(arr[i-k]<0)
			{
				negNum = 0;
				for(int j=i-k+1; j<=i; j++)
				{
					if(arr[j]<0)
					{
						negNum = arr[j];
						break;
					}
				}
			}
			else if(arr[i-k]>=0 && arr[i]<0 && negNum>=0)
				negNum = arr[i];
			res.add(negNum);
		}
		return res;
	}

}
