// @author Cassidy King

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		Project1Methods helpers = new Project1Methods();
		String fileName = "tom-sawyer.txt";
		FileReader fin = null;
		try {
			fin = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner info = new Scanner(fin);
		String key, value;
		ArrayList<String> fileLines = new ArrayList<>();
		while (info.hasNext()) {
			fileLines.add(info.nextLine());
		}
		HashMap<Character, Integer> letterMap = new HashMap<>();
		HashMap<String, Integer> wordMap = new HashMap<>();
		HashMap<String, Integer> stopMap = new HashMap<>();
		HashMap<String, Integer> wordMap1 = new HashMap<>();
		Scanner scan;
		for (String line : fileLines) {
			int count = 0;
			scan = new Scanner(line);
			while (scan.hasNext()) {
				// this will read the line and separate out each word
				scan.useDelimiter("[^a-zA-Z']");
				String word = scan.next();
				word = word.toLowerCase();
				// replace all leading apostrophes
				word = word.replaceAll("^'+", "");
				// replace all trailing apostrophes
				word = word.replaceAll("'+$", "");
				/* now you have a word to put in your map */
				// Note: Make sure to check for empty String
				// don't put an empty string in the map

				// adding letters to letter map
				for (int i = 0; i < word.length(); i++) {
					if (letterMap.containsKey(word.charAt(i)) && word.charAt(i) != ' ') {
						letterMap.put(word.charAt(i), letterMap.get(word.charAt(i)) + 1);
					} else {
						letterMap.put(word.charAt(i), 1);
					}
				}
				// adding words to word map
				if (wordMap.containsKey(word) && !word.equals("")) {
					wordMap.put(word, wordMap.get(word) + 1);
				} else {
					wordMap.put(word, 1);
				}
			}
		}
		// creating stopmap
		stopMap = wordMap;
		wordMap1=stopMap;
		
		// importing stoplist words into an arraylist
		FileReader reader = null;
		try {
			reader = new FileReader("stop-list.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner stopScan = new Scanner(reader);

		ArrayList<String> stopFileLines = new ArrayList<>();
		while (stopScan.hasNext()) {
			stopFileLines.add(stopScan.nextLine());
		}

		// calling helper methods to determine the desired max occurances
		System.out.println("Most used letters: ");
		System.out.println(helpers.getMaxOccuranceChar(letterMap));
		System.out.println("Most used words: ");
		System.out.println(helpers.getMaxOccuranceWord(wordMap));
		// removing the stop list words from stop map
		for (String stop : stopFileLines) {
			if (stopMap.containsKey(stop))
				stopMap.remove(stop);
		}
		System.out.println("Most used words not on stop list: ");
		System.out.println(helpers.getMaxOccuranceWord(wordMap));

		//wildcard - least used words
		System.out.println("The longest words: ");
		System.out.println(helpers.getLowestOccurance(wordMap));
	}
}
