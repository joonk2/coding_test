import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] S = br.readLine().split(" ");
            int cnt = Integer.parseInt(S[0]);
            int[] arr = new int[cnt];
            int sum = 0;


            for (int j = 0; j < cnt; j++) {
                arr[j] = Integer.parseInt(S[j+1]);
                sum += arr[j];

            }

            // avg
            double avg = (double) sum / cnt;
            int student = 0;
            for (int a : arr) {
                if (a > avg) {
                    student++;
                }
            }

            double res = (double) student / cnt * 100;
            String ans = String.format("%.3f", res);
            System.out.println(ans + "%");


        }

        
        

    }
}