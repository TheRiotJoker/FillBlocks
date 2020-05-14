import java.util.Random;

public class Gui {
	public static void main(String[] args) {
		int a = 0;
		int b = -17;
		int c = 23;
		Random rand = new Random();
		System.out.println(rand.nextInt(200)*b+c);
		System.out.println(a);
		System.out.println("nothing");
	}
}
