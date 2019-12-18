package aula11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class WordsAnalysis 
{
	public static void main(String[] args) throws IOException 
	{
		HashMap<String, Integer> words = new HashMap<String,Integer>();
		TreeMap<String, Integer> wordsTreeMap = new TreeMap<String, Integer>();
		
		List<String> fileLines = Files.readAllLines(Paths.get("src/aula11/words.txt"));
		List<String> fileWords = new ArrayList<String>();
		for(String line : fileLines)
		{
			for(String word : line.split(" "))
			{
				fileWords.add(word);
			}
		}
		
		for(String word : fileWords)
		{
			if(!words.containsKey(word))
			{				
				words.put(word, 0);
				wordsTreeMap.put(word, 0);
			}
			words.put(word, words.get(word) + 1);
			wordsTreeMap.put(word, words.get(word) + 1);
		}
		
		words.forEach((k,v) -> {System.out.println(k + " : " + v);});
		System.out.println("Total words: " + words.values().stream().reduce(0, (total, number) -> total + number));
		System.out.println("Unique words: " + words.keySet().size());
		System.out.println("----------------------");
		wordsTreeMap.keySet().stream().sorted((s1, s2) -> s1.compareTo(s2));
		wordsTreeMap.forEach((k,v) -> System.out.println(k + " : " + v));
	}
}
