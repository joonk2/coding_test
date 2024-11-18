import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        for (int i = 1; i < 4; i++) {
            String[] S = br.readLine().split(" ");
            int a = Integer.parseInt(S[0]);
            int b = Integer.parseInt(S[1]);
            int c = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            
            
            if (a+b+c+d == 4) {
                System.out.println("E");
            }
            else if (a+b+c+d == 0) {
                System.out.println("D");
            }
            else if (a+b+c+d == 1) {
                System.out.println("C");
            }
            else if (a+b+c+d == 2) {
                System.out.println("B");
            }
            else if (a+b+c+d == 3) {
                System.out.println("A");
            }
            
        
        }
        
        
        
        
    }
}