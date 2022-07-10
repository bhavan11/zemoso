import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToLeft {

	public static void main(String[] args) {
		int array[] = {4, 5, 2, 25};
		//int array[] = {13, 7, 6, 12};
		//int array[] = {1, 3, 2, 4};
		//int array[] = {1, 3, 0, 0, 1, 2, 4};
		System.out.println(solve(array));
	}
	
	public static ArrayList<Integer> solve(int array[])
	{
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<array.length; i++)
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
