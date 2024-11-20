import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 수열 A를 담을 arr
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int X = Integer.parseInt(br.readLine());
        double sum = 0;
        double cnt = 0;


        for (int j = 0; j < N; j++) {
            if (Euclidean_alg(X, arr[j]) == 1) {
                sum += arr[j];
                cnt++;
            }
        }


        // res
        System.out.println(sum / cnt);
        br.close();

    }





    public static int Euclidean_alg(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }



}