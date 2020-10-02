import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Project1Methods {
	public String getMaxOccuranceWord(HashMap<String, Integer> map) {
		Iterator itr;
		int max;
		Map.Entry maxObj = null;
		Map.Entry pair = null;
		String returnString = "";
		for (int i = 0; i < 10; i++) {
			itr = map.entrySet().iterator();
			max = 0;
			while (itr.hasNext()) {
				pair = (Map.Entry) itr.next();
				if ((int) pair.getValue() > max) {
					max = (int) pair.getValue();
					maxObj = pair;
				}
			}
			map.remove(maxObj.getKey());
			returnString+="Word: " + maxObj.getKey() + " Frequency: " + maxObj.getValue() + "\n";
		}
		
		return returnString;
	}

	public String getMaxOccuranceChar(HashMap<Character, Integer> map) {
		Iterator itr;
		int max;
		Map.Entry maxObj = null;
		Map.Entry pair = null;
		String returnString = "";
		for (int i = 0; i < 10; i++) {
			itr = map.entrySet().iterator();
			max = 0;
			while (itr.hasNext()) {
				pair = (Map.Entry) itr.next();
				if ((int) pair.getValue() > max) {
					max = (int) pair.getValue();
					maxObj = pair;
				}
			}
			map.remove(maxObj.getKey());
			returnString+="Char: " + maxObj.getKey() + " Frequency: " + maxObj.getValue() + "\n";
		}
		
		return returnString;
	}
	
	public String getLowestOccurance(HashMap<String, Integer> map) {
		Iterator itr=map.entrySet().iterator();
		Map.Entry pair = null;
		String returnString = "";
	
			while(itr.hasNext()) {
				pair = (Map.Entry) itr.next();
				if(((String) pair.getKey()).length()>15) {
					returnString += "Word: " + pair.getKey() + " Frequency: " + pair.getValue()+ "\n";	
				}
			}
			map.remove(pair.getKey());
		
		return returnString;
	}
}
