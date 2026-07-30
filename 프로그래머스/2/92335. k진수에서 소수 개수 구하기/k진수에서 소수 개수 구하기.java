import java.util.Arrays;

class Solution {
    static int answer;
    
    public int solution(int n, int k) {
        answer = 0;
        String str= "";
        
        // 1. 진수 변환
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remainder = n % k;
            sb.append(remainder);
            n /= k;
        }
        str += sb.reverse().toString();
        
        // 2. arr에 "0"으로 공백을 부여하여 추가
        String[] arr = str.split("0");
        System.out.println(Arrays.toString(arr));
        
        // 3. 소수 판별
        is_prime(arr);
        return answer;
    }
    
    
    // 4. 소수 판별 함수
    static void is_prime(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 4-1. 예외 처리
            if (arr[i].isEmpty()) continue;
            
            // 4-2. 그 외 2이상 숫자들
            long cur_num = Long.parseLong(arr[i]);
            
            // 4-3. 예외처리
            if (cur_num == 1) continue;
            
            // 4-4. 2이상 숫자들
            boolean prime = true;
            for (int j = 2; j < (int) Math.sqrt(cur_num) + 1; j++) {
                // 4-5. 제곱근 중에 약수가 하나만 나눠져도 소수X
                if (cur_num % j == 0) {
                    prime = false;
                    break;
                }
            }
            // 4-6. 소수 판별이면 answer++
            if (prime) answer++;
        }
    }
    
    
}