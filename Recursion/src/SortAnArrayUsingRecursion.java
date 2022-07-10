import java.util.ArrayList;
import java.util.List;

public class SortAnArrayUsingRecursion {

	public static void main(String[] args) {

		int[] arr = {2, 3, 7, 6, 4, 5, 9};
		System.out.println(sort(arr, 0));
	}
	
	public static List<Integer> sort(int[] arr, int start)
	{
		List<Integer> ans = new ArrayList<Integer>();
		if(start==arr.length-1)
		{
			ans.add(arr[start]);
			return ans;
		}
		
		int curr = arr[start];
		List<Integer> temp = sort(arr, start+1);
		for(int a: temp)
		{
			if(curr<a)
			{
				ans.add(curr);
				curr = Integer.MAX_VALUE;
			}
			ans.add(a);
		}
		return ans;
	}

}
