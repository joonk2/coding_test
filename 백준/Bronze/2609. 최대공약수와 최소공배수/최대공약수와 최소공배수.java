import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] AB = br.readLine().split(" ");
		int A = Integer.parseInt(AB[0]);
		int B = Integer.parseInt(AB[1]);
		int res_1 = my_gcd(A, B);
		int res_2 = my_lcm(A, B);
		System.out.println(res_1);
		System.out.println(res_2);
	}
	
	
	
	public static int my_gcd(int x, int y) {
		while (x % y != 0) {
			int temp = x % y;
			x = y;
			y = temp;
		}
		return y;
	}
	
	
	
	
	public static int my_lcm(int x, int y) {
		int a = x / my_gcd(x, y);
		int b = y / my_gcd(x, y);
		return a * b * my_gcd(x, y);
	}
	
	
	
}