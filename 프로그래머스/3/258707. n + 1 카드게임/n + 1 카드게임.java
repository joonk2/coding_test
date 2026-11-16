import java.util.Set;
import java.util.HashSet;


class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        
        // 1. 내덱, 임시저장소 생성
        Set<Integer> my_deck = new HashSet<>();
        Set<Integer> temp_save = new HashSet<>();
        int N = cards.length;
        int idx = N / 3;
        for (int i = 0; i < idx; i++) {
            int cur_val = cards[i];
            my_deck.add(cur_val);
        }
        
        // 2. 첫 라운드
        int round = 1;
        
        // 3. while (남은 카드가 없을때까지 검사)
        while (idx < N) {
            
            // 3-1. 각 라운드 시작시 카드 2장 뽑기
            int first = cards[idx];
            int second = cards[idx+1];
            temp_save.add(first);
            temp_save.add(second);
            idx += 2;
            
            int leng = my_deck.size();
            int K = temp_save.size();
            
            // 3-2. 내 덱에서 카드 2창 합이 되는지 검사 (우선순위 1번)
            boolean is_first_priority_done = false;
            for (int x : my_deck) {
                int y = N+1 - x;
                if (my_deck.contains(y)) {
                    my_deck.remove(x);
                    my_deck.remove(y);
                    is_first_priority_done = true;
                    break;
                }
            }
            
            // 3-3. 내 덱에서 카드 2장 합 못채워서 -> 내덱 1개 + 임시덱 1개 (코인1) 가능한지 검사
            boolean is_second_priority_done = false;
            if (!is_first_priority_done && coin >= 1) {
                for (int x : my_deck) {
                    int y = N+1 - x;
                    if (temp_save.contains(y)) {
                        my_deck.remove(x);
                        temp_save.remove(y);
                        coin--;
                        is_second_priority_done = true;
                        break;
                    }
                }
            }
            
            // 3-4. 내덱 2장도 안되고, 내덱1 + 임시덱1 도 안될때
            // -> 임시덱 2장 (coin 2)
            boolean is_third_priority_done = false;
            if (!is_first_priority_done && !is_second_priority_done && !is_third_priority_done && coin >= 2) {
                for (int x : temp_save) {
                    int y = N+1 - x;
                    if (temp_save.contains(y)) {
                        temp_save.remove(x);
                        temp_save.remove(y);
                        coin -= 2;
                        is_third_priority_done = true;
                        break;
                    }
                }
            }
            
            // 3-5. 어떤 경우에서도 카드 제출을 못했다면?
            if (!is_first_priority_done && !is_second_priority_done && !is_third_priority_done) {
                break;
            }
            
            // 3-6. 셋중 하나라도 성공시 다음 라운드로
            round++;
        }
        
        // 4. 답
        answer = round;
        return answer;
    }
}