import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] xyz = br.readLine().split(" ");
			int[] triangle_sides = str_to_int(xyz);
			
			if (isValid_angle(triangle_sides)) {
				String res = my_detecter(triangle_sides);
				System.out.println(res);
			}
			else if (!isValid_angle(triangle_sides)) {
				break;
			}
		}
		
	}
	
	
	
	public static String my_detecter(int[] int_arr) {
		String res = "";
		
		int x = int_arr[0];
		int y = int_arr[1];
		int z = int_arr[2];
		
		
		if (x == y && y == z && z == x) {
			res = "Equilateral";
		}
		else if (x + y <= z) {
			res = "Invalid";
		}
		else if ( (x==y && y != z) ||  (y == z && z != x) || (z == x && x != y) ) {
			res = "Isosceles";
		}
		else if (x != y && y != z && z != x) {
			res = "Scalene";
		}
		
		return res;
	}
	
	
	
	
	
	public static boolean isValid_angle(int[] int_arr) {
		int cnt = 0;
		for (int i = 0; i < int_arr.length; i++) {
			if (int_arr[i] == 0) cnt++;
		}
		if (cnt == 3) {
			return false;
		}
		return true;
	}
	
	
	
	public static int[] str_to_int(String[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(res);
		return res;
	}
	
}