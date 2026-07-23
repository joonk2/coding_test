import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        int N = numbers.length;
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // 1. String (x, y)를 비교하여 둘다 합쳤을떄 더 큰수면 내림차순 정렬
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b) );
        
        // 2. 예외처리 000일 경우
        if (arr[0].equals("0")) {
            return "0";
        }
        
        // 3. 합치기
        String answer = "";
        for (int i = 0; i < N; i++) {
            answer +=  arr[i];
        }
        
        // 4. 반환
        return answer;
    }
}