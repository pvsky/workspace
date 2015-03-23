import java.util.Map;
import java.util.TreeMap;

public class FreqTable{
	public FreqTable(){ }
	
	public Map<Double, Character> getTable(){
		Map<Double, Character> table = new TreeMap<Double, Character>();
		//TODO
		table.put( 8.167, 'A');
		table.put( 1.492, 'B');
		table.put( 2.782, 'C');
		table.put( 4.253, 'D');
		table.put( 12.702, 'E');
		table.put( 2.228, 'F');
		table.put( 2.015, 'G');
		table.put( 6.094, 'H');
		table.put( 6.966, 'I');
		table.put( 0.153, 'J');
		table.put( 0.772, 'K');
		table.put( 4.025, 'L');
		table.put( 2.406, 'M');
		table.put( 6.749, 'N');
		table.put( 7.507, 'O');
		table.put( 1.929, 'P');
		table.put( 0.095, 'Q');
		table.put( 5.987, 'R');
		table.put( 6.327, 'S');
		table.put( 9.056, 'T');
		table.put( 2.758, 'U');
		table.put( 0.978, 'V');
		table.put( 2.360, 'W');
		table.put( 0.150, 'X');
		table.put( 1.974, 'Y');
		table.put( 0.074, 'Z');
		
		return table;
	}
}