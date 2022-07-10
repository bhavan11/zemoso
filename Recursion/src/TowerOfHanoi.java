import java.util.concurrent.atomic.AtomicInteger;

public class TowerOfHanoi {

	public static void main(String[] args) {

		int n = 4;
		AtomicInteger count = new AtomicInteger(0);
		solve(n, "A", "B", "C", count);
		System.out.println(count.get());
	}

	public static void solve(int n, String s, String d, String h, AtomicInteger count)
	{
		count.set(count.get()+1);
		if(n==1)
		{
			System.out.println("Moving plate: "+n+" from plate: "+s+" to "+d);
			return;
		}
		solve(n-1, s, h, d, count);
		System.out.println("Moving plate: "+n+" from plate: "+s+" to "+d);
		solve(n-1, h, d, s, count);
	}
}
