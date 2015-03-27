import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Friedmann{
	private Set<Integer> divisors;
	private String input;
	private int bestKey = 0;
	private double bestIndex;
	private double bestDiff;
	
	public Friedmann(Set<Integer> divisors, String input){
		this.divisors = divisors;
		this.input = input;
		this.input = removeWhiteSpace();
		
		getKey();
	}
	
	private void getKey(){
		splitToBlocks();
		System.out.println("Best index of: " + bestIndex + " has a key of length:" + bestKey);
	}
	
	private String removeWhiteSpace(){
		String newInput = new String();
		for(int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			if(c == ' ' || c == '.' || c == ',' || c == '(' || 
					c == ')' || c == '-'){ }
			else newInput += c;
		}
		System.out.println(newInput);
		return newInput;
	}
	
	private void splitToBlocks(){		
		for(Integer k : divisors){
			Set<String> blocks = new HashSet<String>();
			for(int i = 0; i < k; i++ ){
				int add = 0;
				String block = new String("");
				while(i + add < input.length()){
					block += input.charAt(i+add);
					add += k;
				}
				blocks.add(block);
			}
			//TODO count index for block
			double index = countIndex(blocks);
			replaceIndex(index, k);
		}
	}
	
	private double countIndex(Set<String> blocks){
		double index;
		Set<Double> indexes = new HashSet<Double>();
		
		for(String b : blocks){
			index = 0.0;
			Map<Character, Integer> freq = new TreeMap<Character, Integer>();
			Set<Character> characters = new HashSet<Character>();
			int chars = 0;
			
			for(int i = 0; i < b.length(); i++){
					if(!freq.containsKey(b.charAt(i))) {
						characters.add(b.charAt(i));
						freq.put(b.charAt(i), 1);
					}
					else freq.put(b.charAt(i), freq.get(b.charAt(i))+1);
					chars++;
			}
			//TODO have char count, do rest
			for(Character c : characters){
				index += (double)freq.get(c)/(double)b.length();
			}
			indexes.add(index);
		}
		
		index = 0.0;
		for(Double i : indexes){
			index += i;
		}
		index /= (double)blocks.size();
		return index;
	}
	
	private void replaceIndex(double curI, int k){
		if(bestKey == 0){
			bestKey = k;
			bestIndex = curI;
			bestDiff = (curI > 0.06689 )? curI-0.06689 : 0.06689 - curI;
		}else{
			double curDiff = (curI > 0.06689 )? curI-0.06689 : 0.06689 - curI;
			if(curDiff < bestDiff){
				bestKey = k;
				bestIndex = curI;
				bestDiff = curDiff;
			}
		}
	}
}