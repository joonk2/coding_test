import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");

        String A = S[0];
        String B = S[1];

        int reversed_A = reverse_num(A);
        int reversed_B = reverse_num(B);

        System.out.println(Math.max(reversed_A, reversed_B));
    }


    
    public static int reverse_num(String N) {
        StringBuilder sb = new StringBuilder(N);
        return Integer.parseInt(sb.reverse().toString());
    }

    
    

}