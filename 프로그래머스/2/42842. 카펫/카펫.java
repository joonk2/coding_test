class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = -1;
        int height = -1;
        int sum = brown + yellow;
        
        for (int i = 1; i < yellow + 1; i++) {
            int first_mod = -1;
            
            // 만약 나눠지면 first_mod로 설정
            if (yellow % i == 0) {
                first_mod = yellow / i;
            }
            
            // 만약 first_mod가 변경안됬다면 skip
            if (first_mod == -1) continue;
            
            // first_mod가 변경되었다면?
            for (int j = first_mod; j >= 1; j--) {
                int second_mod = -1;
                
                // 만약 나눠질때
                if (yellow % j == 0) {
                    second_mod = yellow / j;
                    
                    // 만약 +2 해준상태에서 일치하면? -> break
                    if ((first_mod + 2) * (second_mod + 2) == sum) {
                        width = first_mod + 2;
                        height = second_mod + 2;
                        break;
                    }
                }
            }
            
            // 만약 width랑 height가 -1이 아니라면 break
            if (width != -1 && height != -1) break;
            
        }
        answer[0] = width;
        answer[1] = height;
        return answer;
    }
}