import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {

	public static void main(String[] args) {
		int[] stocks = {100, 80, 60, 70, 60, 75, 85};
		//int[] stocks = {5, 56, 66, 91, 71, 72, 75, 69, 95, 94};
		System.out.println(solve(stocks));
	}
	
	public static List<Integer> solve(int[] stocks)
	{
		List<Integer> res = new ArrayList<Integer>();
		Stack<Integer[]> stack = new Stack<Integer[]>();
		for(int i=0; i<stocks.length; i++)
		{
			int count=1;
			if(!stack.isEmpty() && stack.peek()[0]<=stocks[i])
			{
				while(!stack.isEmpty() && stack.peek()[0]<=stocks[i])
				{
					count += stack.peek()[1];
					stack.pop();
				}
			}
			res.add(count);
			stack.push(new Integer[] {stocks[i], count});
		}
		return res;
	}

}
