import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();
        int[] arr = new int[26];


        // str의 각 인덱스의 알파벳 등장횟수를 arr에 추가하며 저장
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }


        int max_value = 0;
        char answer = '\n'; // 빈문자

        // 0 ~ 25까지 순회해서 zZa 일 경우 (char) (25 + 'A'); 라서 자동으로 Z
        for (int i = 0; i < arr.length; i++) {
            if (max_value < arr[i]) {
                max_value = arr[i];
                answer = (char) (i + 'A');
            }
        }

        // 제일 많이 나온 횟수 cnt++;
        // Mississipi일때 I=4, S=4라서 cnt=2 됨
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max_value == arr[i]) {
                cnt++;
            }
        }

        // cnt > 1 이면 '?', 그 외는 제일 많이 나온 알파벳 출력
        if (cnt > 1) {
            System.out.println('?');
        }
        else {
            System.out.println(answer);
        }


    }
}
