import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		String str = inputs[0];
		int B = Integer.parseInt(inputs[1]);
		
		long res = Long.parseLong(str, B);
		System.out.println(res);
		
		
	}
}