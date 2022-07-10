import java.util.Stack;

public class ReverseStackUsingRecursion {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
		stack.push(3);
		stack.push(7);
		stack.push(6);
		stack.push(4);
		stack.push(5);
		stack.push(9);
		System.out.println(stack);
		System.out.println(solveReverseStackUsingRecursion(stack));
	}
	
	public static Stack<Integer> solveReverseStackUsingRecursion(Stack<Integer> stack)
	{
		if(stack.size()==1)
			return stack;
		
		int curr = stack.pop();
		stack = solveReverseStackUsingRecursion(stack);
		
		stack = insertAtLast(stack, curr);
		return stack;
	}
	
	public static Stack<Integer> insertAtLast(Stack<Integer> stack, int ele)
	{
		if(stack.isEmpty())
		{
			stack.push(ele);
			return stack;
		}
		
		int curr = stack.pop();
		stack = insertAtLast(stack, ele);
		stack.push(curr);
		
		return stack;
	}

}
