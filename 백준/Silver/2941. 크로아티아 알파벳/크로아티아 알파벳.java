import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int cnt = 0;
		
		// c=, cz, dz=, d-, lj, nj, z=, z=
		// 목록에 없는 알파벳은 1글자씩 가산
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'c' && i < S.length()-1) {
				if (S.charAt(i+1) == '=' || S.charAt(i+1) == '-') {
					i++;
				}
			}
			else if (S.charAt(i) == 'd' && i < S.length()-1) {
				if (S.charAt(i+1) == '-') {
					i++;
				}
				else if (i < S.length()-2 && S.charAt(i+1) == 'z' && S.charAt(i+2) == '=') {
					i += 2;
				}
			}
			else if ( (S.charAt(i) == 'l' || S.charAt(i) == 'n') && i < S.length()-1 ) {
				if (S.charAt(i+1) == 'j') {
					i++;
				}
			} 
			else if ( (S.charAt(i) == 's' || S.charAt(i) == 'z') && i < S.length()-1 ) {
				if (S.charAt(i+1) == '=') {
					i++;
				}
			}
			
			cnt++;
			
			
			
		}
		
		br.close();
		System.out.println(cnt);
		
	}
}