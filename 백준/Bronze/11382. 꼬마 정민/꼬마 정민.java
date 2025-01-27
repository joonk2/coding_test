import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		long A = Long.parseLong(arr[0]);
		long B = Long.parseLong(arr[1]);
		long C = Long.parseLong(arr[2]);
		
		System.out.println(A+B+C);
		
		
	}
}