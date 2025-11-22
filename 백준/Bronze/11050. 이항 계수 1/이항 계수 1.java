import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		C(N, K);
	}
	
	
	
	static void C(int N, int K) {
		int denominator = 1;
		int numerator_1 = 1;
		int numerator_2 = 1;
		
		denominator = recursion(N);
		numerator_1 = recursion(K);
		numerator_2 = recursion(N-K);
		
		int res = denominator / (numerator_1 * numerator_2);
		System.out.println(res);
	}
	
	
	
	static int recursion(int x) {
		if (x <= 1) {
			return 1;
		}
		return x * recursion(x-1);
	}
	
	
	
	
}