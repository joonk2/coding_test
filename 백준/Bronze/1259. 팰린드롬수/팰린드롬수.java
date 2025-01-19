import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		
		while(true) {
			s = br.readLine();
			if (s.equals("0")) {
				break;
			}
			
			boolean isPalendrom = true;
			for (int i = 0; i < s.length(); ++i) {
				if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
					isPalendrom = false;
					break;
				}
			}
			
			if (isPalendrom) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
			
		}
		
		
		
	}
}