import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s_arr = br.readLine().trim().split(" ");
		
		int x = Integer.parseInt(s_arr[0]);
		int y = Integer.parseInt(s_arr[1]);
		int z = Integer.parseInt(s_arr[2]);
		
		
		
		if (x == y && y== z) {
			System.out.println(10000 + (x)*1000);
		}
		else if (x == y || y == z || z == x) {
			// if only 2 values are same
			if (x == y || x == z) {
				System.out.println(1000 + (x)*100);
			}
			else {
				System.out.println(1000 + (y)*100);
			}
		}
		// if 3 values are all different
		else {
			int max = Math.max(x,  Math.max(y, z));
			System.out.println(max*100);
		}
		
		
		}
	}