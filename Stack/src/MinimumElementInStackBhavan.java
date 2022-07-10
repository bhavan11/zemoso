import java.util.Stack;

public class MinimumElementInStackBhavan {
	Stack<Integer> stack;
	//Stack<Integer> suppMinStack;
	int minEle;
	MinimumElementInStackBhavan()
	{
		stack = new Stack<Integer>();
		//suppMinStack = new Stack<Integer>();
	}
	int getMin()
	{
		if(stack.size()==0)
			return -1;
		else
			return minEle;
	}
	
	void push(int ele)
	{
		if(stack.size()==0)
		{
			stack.push(ele);
			minEle=ele;
		}
		else
		{
			if(ele<minEle)
			{
				stack.push(2*ele-minEle);
				minEle = ele;
			}
			else
			{
				stack.push(ele);
			}
		}
	}
	
	void pop()
	{
		if(stack.size()==0)
		{
			return;
		}
		else
		{
			if(stack.peek()>=minEle)
				stack.pop();
			else
			{
				minEle = 2*minEle + stack.pop();
			}
		}
	}
	public static void main(String[] args) {

		MinimumElementInStackBhavan minStack = new MinimumElementInStackBhavan();
		/*minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());*/
		/*minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());*/
		minStack.push(512);
		minStack.push(-1024);
		minStack.push(-1024);
		minStack.push(512);
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
	}

}
