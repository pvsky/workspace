public class Main{
	
	public static void main(String [] args){
		EukAlg euk = new EukAlg(427,133);
		euk.vypocet();
		
		System.out.print("d=" +euk.getD() + ", alfa=" + euk.getAlfa()+", beta=" + euk.getBeta());
	}
}