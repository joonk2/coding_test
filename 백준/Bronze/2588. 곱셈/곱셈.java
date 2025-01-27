import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		String y = br.readLine();
		
		int y3 = y.charAt(2) - '0';
		int y2 = y.charAt(1) - '0';
		int y1 = y.charAt(0) - '0';
		
		int int_y = Integer.parseInt(y);
		
		System.out.println(x*y3);
		System.out.println(x*y2);
		System.out.println(x*y1);
		
		System.out.println(x*int_y);
		
		
	}
}