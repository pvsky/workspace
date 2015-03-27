import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Kasisky{
	private String input;
	private Map<String, Integer> words;
	private Map<String, Set<Integer>> positions;
	private Set<String> repeats;
	private Set<Integer> divisors;
	
	public Kasisky(String input){
		this.input = input;
		words = new TreeMap<String, Integer>();
		positions = new TreeMap<String, Set<Integer>>();
		repeats = new HashSet<String>();
		divisors = new HashSet<Integer>();

		
		refresh();
		findRepeat(5);
		print(5);
		
		refresh();
		findRepeat(8);
		print(8);
		
		refresh();
		findRepeat(10);
		print(10);
	}
	
	private void refresh(){
		words = new TreeMap<String, Integer>();
		positions = new TreeMap<String, Set<Integer>>();
		repeats = new HashSet<String>();
		divisors = new HashSet<Integer>();
	}
	
	private void findRepeat(int length){
		int position = 0;
		
		while(position + length <= input.length()){
			String word = input.substring(position, position+length);
			if(word.contains(" ") || word.contains(".") || 
					word.contains(",") || word.contains("(") || 
					word.contains(")") || word.contains("-")){ }
			else{
				if(words.containsKey(word)){
					repeats.add(word);
					words.put(word, words.get(word)+1);
					Set<Integer> newPos = positions.get(word);
					newPos.add(position);
					positions.put(word, newPos);
				}else{
					words.put(word, 1);
					Set<Integer> newPos = new HashSet<Integer>();
					newPos.add(position);
					positions.put(word, newPos);
				}
			}
			position++;
		}
		
		getLengths();
	}
	
	private void getLengths(){
		Set<Integer> lengths = new HashSet<Integer>();
		
		for(String s : repeats){
			int prev = 0;
			for(Integer p : positions.get(s)){
				if(prev != 0) lengths.add(p-prev);
				prev = p;
			}
		}
		
		getDivisors(lengths);
	}
	
	private void getDivisors(Set<Integer> lengths){
		int max = 0;
		
		for(int i = 0; i < lengths.size(); i++)
		{
			if((int)lengths.toArray()[i] > max) max = (int)lengths.toArray()[i];
		}
		
		for(int i = 2; i < max; i++)
		{
			boolean divisor = false;
			for(Integer l : lengths){
				if(l % i == 0) divisor = true;
			}
			if(divisor) divisors.add(i);
		}
	}
	
	public void print(int length){
		System.out.print("Possible key lengths while scanning for words of length " + length + ": ");
		for(Integer i : divisors){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public Set<Integer> getDivisors(){
		return divisors;
	}
}