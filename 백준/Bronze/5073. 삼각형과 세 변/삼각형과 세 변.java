import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while (true) {
            String[] S = br.readLine().split(" ");
            int[] sides = new int[3];

            for (int i = 0; i < 3; i++) {
                sides[i] = Integer.parseInt(S[i]);
            }

            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) {
                break;
            }



            Arrays.sort(sides);
            int a = sides[0], b = sides[1], c = sides[2];
            

            if (c >= a+b) {
                sb.append("Invalid").append("\n");
            }
            else if (a == b && b == c) {
                sb.append("Equilateral").append("\n");
            }
            else if (a == b || b == c || a == c) {
                sb.append("Isosceles").append("\n");
            }
            else {
                sb.append("Scalene").append("\n");
            }


        }

        System.out.println(sb.toString());


    }
}