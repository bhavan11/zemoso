import java.util.Stack;

public class MinimumElementInStack {
	Stack<Integer> stack;
	Stack<Integer> suppStack;
	public MinimumElementInStack() {
        stack = new Stack<Integer>();
        suppStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(suppStack.isEmpty() || val<=suppStack.peek())
        	suppStack.push(val);
    }
    
    public void pop() {
    	if(stack.isEmpty())
    		return;
    	if(suppStack.peek().intValue()==stack.peek().intValue())
    		suppStack.pop();
    	stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
    	if(suppStack.isEmpty())
    		return -1;
        return suppStack.peek();
    }
	public static void main(String[] args) {
		MinimumElementInStack minStack = new MinimumElementInStack();
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
