import java.util.HashSet;
import java.util.Set;

public class Friedmann{
	private Set<Integer> divisors;
	private String input;
	private int bestKey;
	private double bestIndex;
	
	public Friedmann(Set<Integer> divisors, String input){
		this.divisors = divisors;
		this.input = input;
		this.input = removeWhiteSpace();
		
		getKey();
	}
	
	private void getKey(){
		splitToBlocks();
	}
	
	private String removeWhiteSpace(){
		String newInput = new String();
		for(int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			if(c == ' ' || c == '.' || c == ',' || c == '(' || 
					c == ')' || c == '-'){ }
			else newInput += c;
		}
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
			countIndex(blocks);
		}
	}
	
	private void countIndex(Set<String> blocks){
		
	}
	
	private void countSymbols(){
		
	}
}