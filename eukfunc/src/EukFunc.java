import java.util.HashMap;
import java.util.Map;

public class EukFunc{
	private Map<Integer, Integer> divisors;
	private int number;
	
	public EukFunc(int number){
		this.number = number;
		divisors = new HashMap<Integer, Integer>();
	}
	
	private void getDivisors(int num){
		if(num == 2){
			if(divisors.containsKey(2))
				divisors.put(2, divisors.get(2)+1);
			else divisors.put(2, 1);
			return;
		}
		
		int i = 2;
		boolean found = false;
		
		while(!found){
			if(num % i == 0){
				if(divisors.containsKey(i))
					divisors.put(i, divisors.get(i)+1);
				else divisors.put(i, 1);
				
				found= true;
				getDivisors(num/i);
			}
			else i++;
			
			if(i > Math.sqrt(num) && !found){
				if(divisors.containsKey(num))
					divisors.put(num, divisors.get(num)+1);
				else divisors.put(num, 1);
				return;
			}
		}
		
	}
	
	public int getEukFunc(){
		int euk = 1;
		
		getDivisors(number);
		for(int key : divisors.keySet()){
			if(divisors.get(key) == 1)	euk *= (key-1);
			else{
				int f = divisors.get(key)-1;
				int i = (int) ((key-1)*Math.pow(key, f));
				euk *= i;
			}
		}
		
		for(int key : divisors.keySet()){
			System.out.println("klic: " + key + ", mocnina: " +divisors.get(key) + "   ");
		}
		System.out.println();
		return euk;
	}
}