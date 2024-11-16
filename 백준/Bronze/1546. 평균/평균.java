import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] score = new int[N];
        int max_score = 0;


        // score 배열에 arr의 각 점수 할당
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(arr[i]);
            if (score[i] > max_score) {
                max_score = score[i];
            }
        }


        // 소수점을 포함하여 구하기 위해 double 사용
        double sum = 0;


        // 점수 수정 후 합산 (각 성적 / 최고 성적 * 100)
        for (int i = 0; i < N; i++) {
            sum += (double) score[i] / max_score * 100;
        }


        // 계산
        System.out.println(sum / N);



    }
}