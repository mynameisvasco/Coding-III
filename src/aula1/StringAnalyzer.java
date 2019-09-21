package aula1;

public class StringAnalyzer 
{
	/*DEBUG PROPOSES */
	public static void main(String args[])
	{
		String s = args[0];
		System.out.println("String: " + args[0]);
		System.out.println("Total chars: " + totalDigitChars(s));
		System.out.println("Is only lower case?: " + isOnlyLowerCase(s));
		System.out.println("Is only upper case?: " + isOnlyUpperCase(s));
		System.out.println("Total words: " + totalWords(s));
		System.out.println("Swap 2 chars: " + swap2Chars(s));
	}
	
	public static int totalDigitChars(String s)
	{
		int charNum = 0;
		
		for(char c : s.toCharArray())
		{
			if(Character.isDigit(c))
			{
				charNum++;
			}
		}
		
		return charNum;
	}
	
	public static boolean isOnlyLowerCase(String s)
	{
		for(char c : s.toCharArray())
		{
			if(Character.isUpperCase(c))
			{
				return false;
			}
		}
		
		return true;
	}	
	
	public static boolean isOnlyUpperCase(String s)
	{
		for(char c : s.toCharArray())
		{
			if(Character.isLowerCase(c))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static int totalWords(String s)
	{
		int wordsNum = 0;
		
		for(String s1 : s.split(" "))
		{
			wordsNum++;
		}
		
		return wordsNum;
	}
	
	public static String swap2Chars(String s)
	{
		String tmp = "";
		for(int i = 0; i < s.length() - 1; i++)
		{
			if(!Character.isWhitespace(s.charAt(i)) && !Character.isWhitespace(s.charAt(i + 1)))
			{
				tmp += String.valueOf(s.toCharArray()[i + 1]) + String.valueOf(s.toCharArray()[i]);
				i++;
			}
			else
			{
				tmp += String.valueOf(s.charAt(i));
			}
		}
		
		return tmp;
	}

}
