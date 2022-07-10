import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		String s = "abcabcbb";//3
		//String s = "bbbbb";//1
		//String s = "pwwkew";//3
		System.out.println(solveLongestSubStringWithoutRepeatingCharacters(s));
	}
	
	public static int solveLongestSubStringWithoutRepeatingCharacters(String s)
	{
		int start = 0;
		int length = 0;
		int maxLength = 0;
		HashSet<Character> set = new HashSet<Character>();
		
		for(int i=0; i<s.length(); i++)
		{
			if(set.contains(s.charAt(i)))
			{
				while(set.contains(s.charAt(i)))
				{
					set.remove(s.charAt(start++));
					length--;
				}
				set.add(s.charAt(i));
				length++;
			}
			else
			{
				set.add(s.charAt(i));
				length++;
			}
			
			maxLength = Math.max(maxLength, length);
		}
		
		return maxLength;
	}

}
