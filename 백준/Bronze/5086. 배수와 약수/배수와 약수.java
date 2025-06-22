import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);
			
			if (A == 0 && B == 0) {
				break;
			}
			
			String answer = detecter(A, B);
			System.out.println(answer);
		}
	
		
		
	}
	
	
	
	public static String detecter(int x, int y) {
		String res = "";
		// gcd
		if (y > x && y % x == 0) {
			res = "factor";
		}
		
		// lcd
		else if (x > y && x % y == 0) {
			res = "multiple";
		}
		// nor
		else {
			res = "neither";
		}
		return res;
	}
	
	
	
}