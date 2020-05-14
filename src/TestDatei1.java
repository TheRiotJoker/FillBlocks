import java.util.Random;
public class TestDatei1 {
	public TestDatei1() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Integer.toString(zufallsZahl()));
		}
	}
	private int zufallsZahl() {
		Random random = new Random();
		return random.nextInt(200);
	}
}
