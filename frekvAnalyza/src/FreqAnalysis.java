import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class FreqAnalysis{
	private Map<Double, Character> table;
	private Map<Character, Double> freq;
	private Map<Character, Character> result;
	
	private Set<Character> characters;
	private String input;
	private String output;
	
	public FreqAnalysis(String input){
		this.input = input;
		this.output = input;
		
		freq = new TreeMap<Character, Double>();
		table = new FreqTable().getTable();
		result = new TreeMap<Character, Character>();
		
		getFreq();
	}

	private void getFreq(){
		characters = new HashSet<Character>();
		int chars = 0;
		
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == ' ' || input.charAt(i) == ',' || input.charAt(i) == '.' || 
					input.charAt(i) == '(' || input.charAt(i) == ')' || input.charAt(i) == '1' || 
					input.charAt(i) == '0' || input.charAt(i) == '-') {}
			else{
				if(!freq.containsKey(input.charAt(i))) {
					characters.add(input.charAt(i));
					freq.put(input.charAt(i), 1.0);
				}
				else freq.put(input.charAt(i), freq.get(input.charAt(i))+1.0);
				
				chars++;
			}	
		}
		
		
		for(Character c : characters){
			freq.put(c, freq.get(c)/((double)chars/100));
		}
		
		bindFreqs();
	}
	
	private void bindFreqs() {
		// TODO Auto-generated method stub
		Set<Double> freqsEN = new TreeSet<Double>(table.keySet());
		
		for(Character c : characters){
			int i = 0;
			boolean done = false;
			
			while(!done && i< freqsEN.size()){
				if(freq.get(c) > (Double)freqsEN.toArray()[i+1]){
					i++;
				}
				else{				
					if((Double)freqsEN.toArray()[i+1] - freq.get(c) > freq.get(c) - (Double)freqsEN.toArray()[i])
						result.put(c, table.get((Double)freqsEN.toArray()[i]));
					else result.put(c, table.get((Double)freqsEN.toArray()[i+1]));
					done = true;
				}
			}
		}
	}

	public void printResult(){	
		for(Character c : characters){
			System.out.print(c + ": " + freq.get(c) + "\t\t\t");
			System.out.println(c + ": " + result.get(c));
		}
		
		
		//Deciphered text
		for(Character c : characters){
			input = input.replace(c , Character.toLowerCase(result.get(c)));
		}
		System.out.println(input);
	}
}