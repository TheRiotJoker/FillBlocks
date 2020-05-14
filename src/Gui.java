import java.util.Random;

public class Gui {
	public static void main(String[] args) {
		int a = 0;
		int b = -17;
		int c = 23;
		Steuerung steuerung = new Steuerung();
		Random rand = new Random();
		System.out.println(rand.nextInt(200)*b+c);
		System.out.println(a);
		System.out.println("nothing");
		for(int d = 0; d < rand.nextInt(10);d++) {
			System.out.println("Nothing");
		}
	}
}
