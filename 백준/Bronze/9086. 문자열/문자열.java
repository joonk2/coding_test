import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String words = br.readLine();
			if (words.length() > 1) {
				char first_ch = words.charAt(0);
				char last_ch = words.charAt(words.length()-1);
				System.out.println(first_ch + "" +  last_ch);
			}
			if (words.length() == 1) {
				char first_ch = words.charAt(0);
				char last_ch = words.charAt(0);
				System.out.println(first_ch + "" + last_ch);
			}
			
		}
		
	}
}