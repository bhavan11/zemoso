import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToRight {

	public static void main(String[] args) {
		//int array[] = {4, 5, 2, 25};
		//int array[] = {13, 7, 6, 12};
		//int array[] = {1, 3, 2, 4};
		//int array[] = {1, 3, 0, 0, 1, 2, 4};
		int array[] = {73,74,75,71,69,72,76,73};
		List<Integer> result = solve(array);
		Collections.reverse(result);
		System.out.println(result);
	}
	
	public static ArrayList<Integer> solve(int array[])
	{
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=array.length-1; i>=0; i--)
		{
			if(stack.isEmpty())
				result.add(-1);
			else
			{
				while(stack.peek()<=array[i])
				{
					stack.pop();
					if(stack.isEmpty())
						break;
				}
				if(stack.isEmpty())
					result.add(-1);
				else
					result.add(stack.peek());
			}
			stack.push(array[i]);
		}
		return result;
	}

}
