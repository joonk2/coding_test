import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputs[0]);
		int B = Integer.parseInt(inputs[1]);
		
		String res = Integer.toString(N, B).toUpperCase();
		System.out.println(res);
		
		
	}
}