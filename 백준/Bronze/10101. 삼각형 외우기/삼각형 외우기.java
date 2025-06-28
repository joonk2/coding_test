import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		String res = my_detecter(a, b, c);
		System.out.println(res);
	}
	
	
	public static String my_detecter(int x, int y, int z) {
		String res = "";
		int sum = 0;
		sum += x;
		sum += y;
		sum += z;
		
		if (sum == 180) {
			if (x == 60 && y == 60 && z == 60) {	
				res = "Equilateral";
			}
			else if ( (x == y && y != z) || (y == z && x != z) || (z == x && x != y) ) {
				res = "Isosceles";
			}
			else if (x != y && y != z && z != x) {
				res = "Scalene";
			}
		}
		else {
			res = "Error";
		}
		
		
		return res;
	}
	
	
}