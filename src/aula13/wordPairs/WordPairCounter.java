package aula13.wordPairs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WordPairCounter 
{
	private HashMap<String, HashMap<String, Integer>> pairs;
	
	public static void main(String[] args) throws IOException 
	{
		HashMap<String, HashMap<String, Integer>> wordPairs = new HashMap<String, HashMap<String, Integer>>();
		
		String[] words = readFromFile("src/aula13/wordPairs/Policarpo.txt");
		
		for(int i = 0; i < words.length -1; i++)
		{
			ifCondition:
			if(wordPairs.containsKey(words[i]))
			{
				for(String key : wordPairs.get(words[i]).keySet())
				{
					if(key.equals(words[i+1]))
					{
						wordPairs.get(words[i]).put(words[i+1], wordPairs.get(words[i]).get(words[i+1]) + 1);
						break ifCondition;
					}
				}
				
				wordPairs.get(words[i]).put(words[i+1], 1);
			}
			else
			{
				wordPairs.put(words[i], new HashMap<String,Integer>());
				wordPairs.get(words[i]).put(words[i+1], 1);
			}
		}
		
		wordPairs.forEach((k,v) -> System.out.println(k + " " + v));
	}
	
	public static String[] readFromFile(String path) throws IOException
	{
		List<String> lines = Files.readAllLines(Paths.get(path));
		
		return Arrays.stream(lines.stream().collect(Collectors.joining(" "))
		.split("[-|\t|\n| |.|,|:|'|,|;|?|!|*|{|}|=|+|&|/|(|)|[|]|\"|'|“|”|‘|’]"))
		.filter((s) -> s.length() >= 3)
		.map((s) -> s.toLowerCase())
		.collect(Collectors.toList()).toArray(new String[0]);
		
	}
}
