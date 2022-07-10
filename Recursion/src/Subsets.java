import java.util.ArrayList;
import java.util.List;

public class Subsets {

	static List<List<Integer>> res = new ArrayList<List<Integer>>();
	public static void main(String[] args) {

		int[] nums = {1,2,3};
		System.out.println(subsets(nums));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		res.clear();
		solveSubsets(nums, 0, new ArrayList<Integer>());
		return res;
    }
	
	public static void solveSubsets(int[] nums, int index, List<Integer> temp)
	{
		if(index>=nums.length)
		{
			res.add(temp);
			return;
		}
		
		//solveSubsets(inp.substring(1), out+inp.charAt(0));
		List<Integer> temp1 = new ArrayList<Integer>(temp);
		temp1.add(nums[index]);
		solveSubsets(nums, index+1, temp1);
		if(index<nums.length-1)
		{
			while(index<nums.length-1 && nums[index]==nums[index+1])
				index++;
		}
		List<Integer> temp2 = new ArrayList<Integer>(temp);
		solveSubsets(nums, index+1, temp2);
			
	}
}
