import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerToLeft {

	public static void main(String[] args) {
		
		//int array[] = {4, 5, 2, 10, 8};
		int array[] = {3, 2, 1};
		System.out.println(solve(array));
	}
	
	public static int[] solve(int[] array)
	{
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<array.length; i++)
		{
			if(stack.isEmpty())
				result.add(-1);
			else
			{
				while(!stack.isEmpty() && stack.peek()>=array[i])
					stack.pop();
				
				if(stack.isEmpty())
					result.add(-1);
				else
					result.add(stack.peek());
			}
			stack.push(array[i]);
		}
		
		//return result;
		int[] res = new int[result.size()];
		for (int i =0; i < result.size(); i++)
            res[i] = result.get(i);
		
		return res;
	}

}
