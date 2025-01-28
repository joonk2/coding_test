import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s_arr = br.readLine().split(" ");
		int A = Integer.parseInt(s_arr[0]);
		int B = Integer.parseInt(s_arr[1]);
		
		int C = Integer.parseInt(br.readLine());
		
		if (B+C < 60)  {
			B = B+C;
			System.out.println(A + " " + B);
		}
		else {
			int quotient = (B+C) / 60;
			B = (B+C) % 60;
			A += quotient;
			A %= 24;
			System.out.println(A + " " + B);
		}
		
		
		
	}
}