import java.util.Stack;

public class SortAStack {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
		stack.push(3);
		stack.push(7);
		stack.push(6);
		stack.push(4);
		stack.push(5);
		stack.push(9);
		
		System.out.println(solveSortAStack(stack));
	}

	public static Stack<Integer> solveSortAStack(Stack<Integer> stack)
	{
		if(stack.size()==1)
			return stack;
		
		int curr = stack.pop();
		Stack<Integer> ans = solveSortAStack(stack);
		Stack<Integer> temp = new Stack<Integer>();
		while(curr<ans.peek())
			temp.push(ans.pop());
		
		ans.push(curr);
		while(!temp.isEmpty())
			ans.push(temp.pop());
		
		return ans;
	}
}
