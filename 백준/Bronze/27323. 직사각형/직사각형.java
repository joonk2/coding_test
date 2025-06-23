import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int answer = my_detecter(A, B);
		System.out.println(answer);
	}
	
	public static int my_detecter(int x, int y) {
		int res = 0;
		res = x*y;
		return res;
	}
}