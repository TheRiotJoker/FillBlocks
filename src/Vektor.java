
public class Vektor {
	private int x1 = 0;
	private int x2 = 0;
	private int x3 = 0;
	public Vektor() {
	}
	public Vektor(int x1, int x2, int x3) {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
	}
	public int getX1() {
		return x1;
	}
	public int getX2() {
		return x2;
	}
	public int getX3() {
		return x3;
	}
	public void setVektor(int x1, int x2, int x3) {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
	}
	public String stringVektor() {
		return "("+Integer.toString(x1)+","+Integer.toString(x2)+","+Integer.toString(x3)+"\n)";
	}
}
