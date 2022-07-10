import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {

	public static void main(String[] args) {

		//String s = "aabbcc";
		//int k = 1;//2
		//String s = "aabbcc";
		//int k = 2;//4
		//String s = "aabbcc";
		//int k = 3;//6
		//String s = "aaabbb";
		//int k = 3;//0
		String s = "aabacbebebe";
		int k = 3;//7
		System.out.println(solveLongestSubstringWithKUniqueCharacters(s, k));
	}

	public static int solveLongestSubstringWithKUniqueCharacters(String s, int k)
	{
		int start = 0;
		int maxLength = 0;
		int length=0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++)
		{
			Integer tempCount = map.get(s.charAt(i));
			if(tempCount==null)
				tempCount = 1;
			else
				tempCount++;
			map.put(s.charAt(i), tempCount);
			
			length++;
			if(map.size()==k)
				maxLength = Math.max(maxLength, length);
			else if(map.size()>k)
			{
				while(map.size()>k)
				{
					tempCount = map.get(s.charAt(start));
					tempCount--;
					if(tempCount==0)
						map.remove(s.charAt(start));
					else
						map.put(s.charAt(start), tempCount);
					start++;
					length--;
				}
				if(map.size()==k)
					maxLength = Math.max(maxLength, length);
			}
		}
		
		return maxLength;
	}
}
