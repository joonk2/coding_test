import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String words = br.readLine();
		int[] alphabet_dict = new int[26];
		
		for (int i = 0; i < 26; i++) {
			alphabet_dict[i] = -1;
		}
		
		for (int i = 0; i < words.length(); i++) {
			char ch = words.charAt(i);
			int target_idx = ch-'a';
//			System.out.println(ch);
//			System.out.println(ch-'a');
			
			if (alphabet_dict[target_idx] == -1) {
				alphabet_dict[target_idx] = i;
			}
			
		}
		
		
		
//		System.out.println(Arrays.toString(alphabet_dict));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (i < 25) {
				sb.append(alphabet_dict[i] + " ");
			}
			else {
				sb.append(alphabet_dict[i]);
			}
		}
		
		System.out.println(sb);
	}
}