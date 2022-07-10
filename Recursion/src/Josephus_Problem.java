import java.util.ArrayList;
import java.util.List;

public class Josephus_Problem {

	public static void main(String[] args) {

		int n = 3;
		int k = 2;//3
		//int n = 5;
		//int k = 3;//4
		System.out.println(solveJosephus_Problem(n, k));
	}
	
	public static int solveJosephus_Problem(int n, int k)
	{
		List<Integer> men = new ArrayList<Integer>();
		for(int i=1; i<=n; i++)
			men.add(i);
		return solve(k, men, 0);
	}
	
	public static int solve(int k, List<Integer> men, int startIndex)
	{
		if(men.size()==1)
			return men.get(0);
		
		int indexOfMenToDie = (k+startIndex-1)%men.size();
		men.remove(indexOfMenToDie);
		
		return solve(k, men, indexOfMenToDie);
	}

}
