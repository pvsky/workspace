import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Kasisky{
	private String input;
	private Map<String, Integer> words;
	private Map<String, Set<Integer>> positions;
	private Set<String> repeats;

	
	private Kasisky(String input){
		this.input = input;
		words = new TreeMap<String, Integer>();
		positions = new TreeMap<String, Set<Integer>>();
		repeats = new HashSet<String>();
		
		findRepeat(3);
	}
	
	private void findRepeat(int length){
		int position = 0;
		
		while(position + length <= input.length()){
			String word = input.substring(position, length);
			if(word.contains(" ") || word.contains(".") || 
					word.contains(",") || word.contains("(") || 
					word.contains(")") || word.contains("-")){ }
			else{
				if(words.containsKey(word)){
					repeats.add(word);
					words.put(word, words.get(word)+1);
					Set<Integer> newPos = positions.get(word);
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
	}
	
	private void getLengths(){
		Set<Integer> lengths = new HashSet<Integer>();
		
		for(String s : repeats){
			int prev = 0;
			for(Integer p : positions.get(s)){
				if(prev != 0) lengths.add(p-prev);
			}
		}
		
		getDivisors(lengths);
	}
	
	private void getDivisors(Set<Integer> lengths){
		//TODO
	}
}