import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();
        int[] arr = new int[26];

        // arr[0] x 26 에서 각 i번째 index마다 str 각 단어의 횟수 저장
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }

        int max_value = 0;
        char answer = '?';

        // 0 ~ 25까지 순회해서 Zza 일 경우 (char) (25 + 'A'); 라서 자동으로 Z
        for ( int i = 0; i < arr.length; i++) {
            if (max_value < arr[i]) {
                max_value = arr[i];
                answer = (char) (i+ 'A');
            }
        }
        
        // cnt 가 1이면 제일 많이 나온 알파벳 출력, 그 외는 "?"
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max_value) {
                cnt++;
            }
        }

        if (cnt > 1) {
            System.out.println("?");
        }
        else {
            System.out.println(answer);
        }


    }
}