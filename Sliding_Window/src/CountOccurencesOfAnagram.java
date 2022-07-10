import java.util.HashMap;
import java.util.Map;

public class CountOccurencesOfAnagram {

	public static void main(String[] args) {

		//String s = "aabaabaa";
		//String ptr = "aaba";
		//String s = "forxxorfxdofr";
		//String ptr = "for";
		String s = "aaaaaaaaaa";
		String ptr = "aaaaaaaaaaaaa";
		System.out.println(solveCountOccurencesOfAnagram(s, ptr));
	}
	
	public static int solveCountOccurencesOfAnagram(String s, String ptr)
	{
		if(ptr.length()>s.length())
			return 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<ptr.length(); i++)
			map.put(ptr.charAt(i), map.get(ptr.charAt(i))!=null?map.get(ptr.charAt(i))+1:1);
		
		int count = map.size();
		
		int ans = 0;
		for(int i=0; i<ptr.length(); i++)
		{
			Integer countTemp = map.get(s.charAt(i));
			if(countTemp!=null)
			{
				map.put(s.charAt(i), --countTemp);
				if(countTemp==0)
					count--;
			}
		}
		if(count==0)
			ans++;
		for(int i=ptr.length(); i<s.length(); i++)
		{
			Integer countTempNext = map.get(s.charAt(i));
			if(countTempNext!=null)
			{
				map.put(s.charAt(i), --countTempNext);
				if(countTempNext==0)
					count--;
			}
			
			Integer countTempPrev = map.get(s.charAt(i-ptr.length()));
			if(countTempPrev!=null)
			{
				map.put(s.charAt(i-ptr.length()), ++countTempPrev);
				if(countTempPrev==1)
					count++;
			}
			
			
			if(count==0)
				ans++;
		}
		return ans;
	}

}
