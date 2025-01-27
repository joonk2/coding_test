import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s_arr = br.readLine().split(" ");
		int H = Integer.parseInt(s_arr[0]);
		int M = Integer.parseInt(s_arr[1]);
		
		if (M < 45) {
			H--;
			M = 60+M-45;
			
			if (H < 0) {
				H = 23;
			}
			System.out.println(H + " " + (M));
		}
		else {
			System.out.println(H + " " + (M-45));
		}
		
		
	}
}