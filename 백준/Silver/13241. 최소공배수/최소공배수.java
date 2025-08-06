import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] AB = br.readLine().split(" ");
		long A = Long.parseLong(AB[0]);
		long B = Long.parseLong(AB[1]);
		long res = lcm(A, B);
		System.out.println(res);
	}
	
	
	
	
	public static long lcm(long x, long y) {
		return (x*y) / gcd(x, y);
	}
	
	
	
	public static long gcd(long x, long y) {
		while (y != 0) {
			long temp = x % y;
			x = y;
			y = temp;
		}
		return x;
	}
	
	
	
	
}