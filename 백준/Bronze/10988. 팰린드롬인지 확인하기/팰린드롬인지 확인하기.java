import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		boolean IsPalendrome = true;
		for (int i = 0; i < S.length() / 2 ; i++) {
			if (S.charAt(i) != S.charAt(S.length()-1-i)) {
				IsPalendrome = false;
				break;
			}
		}
		
		if (IsPalendrome == true) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
		
	}
}