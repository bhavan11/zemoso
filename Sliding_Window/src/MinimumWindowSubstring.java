import java.util.HashMap;

public class MinimumWindowSubstring {

	public static void main(String[] args) {

		String s = "ADOBECODEBANC";
		String t = "ABC";
		//String s = "a";
		//String t = "aa";
		//String s = "a";
		//String t = "b";
		//String s = "ab";
		//String t = "b";
		//String s = "aa";
		//String t = "aa";
		System.out.println(solveMinimumWindowSubstring(s, t));
	}

	public static String solveMinimumWindowSubstring(String s, String t)
	{
		if(t.length()>s.length())
			return "";
		String res="";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<t.length(); i++)
		{
			Integer count = map.get(t.charAt(i));
			if(count==null)
				count = 1;
			else
				count++;
			map.put(t.charAt(i), count);
		}
		int count = map.size();
		
		int length=0;
		int start = 0;
		int minLength = Integer.MAX_VALUE;
		for(int i=0; i<s.length(); i++)
		{
			Integer tempCount = map.get(s.charAt(i));
			if(tempCount!=null)
			{
				map.put(s.charAt(i), --tempCount);
				if(tempCount==0)
					count--;
				else if(tempCount==-1)
					count++;
			}
			
			length++;
			while(count>=0 && start<=i)
			{
				if(start>=s.length())
					break;
				Integer countStart = map.get(s.charAt(start));
				if(countStart==null)
				{
					start++;
					length--;
				}
				else
				{
					if(countStart>=0)
						break;
					else
					{
						++countStart;
						map.put(s.charAt(start), countStart);
						if(countStart==1)
							count++;
						else if(countStart==0)
							count--;
						start++;
						length--;
					}
				}
			}
			if(length<minLength && count == 0)
			{
				minLength=length;
				res = s.substring(start, start+length);
			}
		}
		//System.out.println(minLength);
		return res;
	}
}
