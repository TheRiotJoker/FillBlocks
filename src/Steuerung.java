import java.text.DecimalFormat;

public class Steuerung {
	//make a displayable array of all vectors that have been calculated
	private Gui gui;
	private int tempZahl;
	private DecimalFormat f;
	public Steuerung(Gui gui) {
		this.gui = gui;
		f = new DecimalFormat("##.00");
		
	}
	public Vektor kreuzproduktBerechnen(Vektor v1, Vektor v2) {
		int x1;
		x1 = (v1.getX2()*v2.getX3())-(v1.getX3()*v2.getX2());
		int x2;
		x2 = (v1.getX3()*v2.getX1())-(v1.getX1()*v2.getX3());
		int x3;
		x3 = (v1.getX1()*v2.getX2())-(v1.getX2()*v2.getX1());
		
		return new Vektor(x1,x2,x3);
	}
	public Vektor summeBerechnen(Vektor v1, Vektor v2) {
		int x1;
		int x2;
		int x3;
		x1 = v1.getX1() + v2.getX1();
		x2 = v1.getX2() + v2.getX2();
		x3 = v1.getX3() + v2.getX3();
		return new Vektor(x1,x2,x3);
	}
	public Vektor differenzBerechnen(String text, Vektor v1, Vektor v2) {
		int x1;
		int x2;
		int x3;
		x1 = v1.getX1() - v2.getX1();
		x2 = v1.getX2() - v2.getX2();
		x3 = v1.getX3() - v2.getX3();
		if(text.contentEquals("Vektor 2 - Vektor 1")) {
			x1 *= -1;
			x2 *= -1;
			x3 *= -1;
		}
		return new Vektor(x1,x2,x3);
	}
	public int skalarProduktBerechnen(Vektor v1, Vektor v2) {
		return v1.getX1()*v2.getX1()+v1.getX2()*v2.getX2()+v1.getX3()*v2.getX3();
	}
	public double winkelBerechnen(Vektor v1, Vektor v2) {
		int skalarProdukt = skalarProduktBerechnen(v1, v2);
		double v1Laenge = vektorLaenge(v1);
		double v2Laenge = vektorLaenge(v2);
		return Double.parseDouble(f.format(Math.toDegrees(Math.acos(skalarProdukt/(Math.sqrt(v1Laenge)*Math.sqrt(v2Laenge))))));
	
	
	}
	public int vektorLaenge(Vektor v1) {
		int x1 = v1.getX1()*v1.getX1();
		int x2 = v1.getX2()*v1.getX2();
		int x3 = v1.getX3()*v1.getX3();
		int sum = x1+x2+x3;
		tempZahl = sum;
		return sum;
	}
	public double vektorLaengeWurzel() {
		return Double.parseDouble(f.format(Math.sqrt(tempZahl)));
	}
}
