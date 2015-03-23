public class EukAlg{
	private int d, a, b;
	private int q,r;
	private int alfa, alfa1, alfa2, beta, beta1, beta2;
	
	public EukAlg(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public void vypocet(){
		if(b == 0){
			d = a;
			alfa = 1;
			beta = 0;
			return;
		}else{
			alfa2 = 1;
			alfa1 = 0;
			beta2 = 0;
			beta1 = 1;
			
			while(b > 0){
				q = a/b;
				r = a % b;
				a = b;
				b = r;
				int prevAlfa2 = alfa2;
				alfa2 = alfa1;
				alfa1 = prevAlfa2-q*alfa1;
				
				int prevBeta2 = beta2;
				beta2 = beta1;
				beta1 = prevBeta2-q*beta1;
			}
			d = a;
			alfa = alfa2;
			beta = beta2;
		}
	}

	public int getD() {
		return d;
	}

	public int getAlfa() {
		return alfa;
	}

	public int getBeta() {
		return beta;
	}

	
	
}