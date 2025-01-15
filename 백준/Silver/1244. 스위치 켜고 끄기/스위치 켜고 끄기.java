import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 스위치 개수
        int[] arr = new int[N + 1];

        // 스위치 상태 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 수 입력
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int card = Integer.parseInt(st.nextToken());

            // 남학생 처리
            if (gender == 1) {
                for (int j = card; j <= N; j += card) {
                    arr[j] = 1 - arr[j];
                }
            }
            // 여학생 처리
            else if (gender == 2) {
                int left = card;
                int right = card;
                while (left > 0 && right <= N && arr[left] == arr[right]) {
                    if (left == right) {
                        arr[left] = 1 - arr[left];
                    } else {
                        arr[left] = 1 - arr[left];
                        arr[right] = 1 - arr[right];
                    }
                    left--;
                    right++;

                    // 범위 체크 수정: right가 N을 초과하면 종료
                    if (left < 1 || right > N) {
                        break;
                    }
                }
            }
        }

       
        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i]);
            if (i % 20 == 0 || i == N) { // 20개씩 출력 또는 마지막 줄 처리
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
        
        
        
        
    }
}
