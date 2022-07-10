import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestSmallerToRight {

	public static void main(String[] args) {
		
		//int[] array = {4, 8, 5, 2, 25};
		int[] array = {13, 7, 6, 12};
		List<Integer> res = solve(array);
		Collections.reverse(res);
		System.out.println(res);
	}

	private static List<Integer> solve(int[] array) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=array.length-1; i>=0; i--)
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
			
			stack.add(array[i]);
		}
		
		return result;
	}

}
