
public class VektorenDaten {
	private int index = 0;
	private Vektor rechnenVektor1;
	private Vektor rechnenVektor2;
	private Vektor loesungsVektor;
	public VektorenDaten() {
		rechnenVektor1 = new Vektor();
		rechnenVektor2 = new Vektor();
		loesungsVektor = new Vektor();
	}
	public void setzeRechnenVektor1(int x1, int x2, int x3) {
		rechnenVektor1.setVektor(x1, x2, x3);
	}
	public void setzeRechnenVektor2(int x1, int x2, int x3) {
		rechnenVektor2.setVektor(x1, x2, x3);
	}
	public Vektor gibRechnenVektor1() {
		return rechnenVektor1;
	}
	public Vektor gibRechnenVektor2() {
		return rechnenVektor2;
	}
}
