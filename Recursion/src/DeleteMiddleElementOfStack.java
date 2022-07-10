import java.util.Stack;

public class DeleteMiddleElementOfStack {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
		stack.push(3);
		stack.push(7);
		stack.push(6);
		stack.push(4);
		stack.push(5);
		stack.push(9);
		int mid = stack.size()/2 +1;
		System.out.println(solveDeleteMiddleElementOfStack(stack, mid));
	}

	public static Stack<Integer> solveDeleteMiddleElementOfStack(Stack<Integer> stack, int mid)
	{
		if(mid==1)
		{
			stack.pop();
			return stack;
		}
		
		int curr = stack.pop();
		mid--;
		stack = solveDeleteMiddleElementOfStack(stack, mid);
		stack.push(curr);
		return stack;
	}
}
