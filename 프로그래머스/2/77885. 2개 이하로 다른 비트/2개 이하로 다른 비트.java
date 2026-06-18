class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int N = answer.length;
        
        // 1. 검사
        for (int i = 0; i < N; i++) {
            // 2. 시작 숫자가 짝수라면? (무조건 다음 숫자는 홀수고, 자연스럽게 최소)
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            }
            
            // 3. 홀수라면?
            else if (numbers[i] % 2 != 0) {
                String bit = Long.toString(numbers[i], 2);
                
                // 3-1. 전부 1이거나
                if (!bit.contains("0")) {
                    // 3-1-a. ex) 01111 일때 10 + idx 1부터인 111 하면10111 
                    // 그러면 다른비트는 딱 2개차이
                    String next_bit = "10" + bit.substring(1);
                    long num = Long.parseLong(next_bit, 2);
                    answer[i] = num;
                }
                // 3-2. 0이 섞여있거나
                else if (bit.contains("0")) {
                    int lastZeroIdx = bit.lastIndexOf("0");
                    
                    // 3-2.a 변환
                    // ex-1) 1011 -> 1101
                    // ex-2) 10101 -> 10110
                    
                    // 3-3. 찾은 0의 idx 전까지 + "10" + 0의 인덱스 + 2칸부터 ("10"을 더했으니)
                    String next_bit = bit.substring(0, lastZeroIdx) + "10" + bit.substring(lastZeroIdx + 2);
                    answer[i] = Long.parseLong(next_bit, 2);
                }
                
                
            }
            
            
        }
        
        
        return answer;
    }
}