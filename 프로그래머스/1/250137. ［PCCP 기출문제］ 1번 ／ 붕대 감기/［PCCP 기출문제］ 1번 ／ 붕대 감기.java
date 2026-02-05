class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // max 피해량
        int N = Integer.MIN_VALUE;
        for (int i = 0; i < attacks.length; i++) {
            int temp_val = attacks[i][0];
            if (temp_val > N) N = temp_val;
        }
        
        int i = 1;
        int j = 0;
        
        // 누적 치료시간
        int cum_heal_cnt = bandage[0];
        
        // 회복량
        int heal = bandage[1];
        
        // 추가 회복량
        int additional_heal = bandage[2];
        
        // 공격 받았는지 안받았는지 유무
        boolean attacked = false;
        
        // 치료 횟수
        int heal_cnt = 0;
        
        // 현재 체력
        int cur_health = health;
        
        // 답 확인을 위한 flag
        boolean flag = true;
        
        // 확인
        while (i <= N) {
            int time = attacks[j][0];
            int damage = attacks[j][1];
            
            // 1. 공격 안받았으면
            if (i != time) {
            	heal_cnt++;
                attacked = false;
            }
            // 2. 공격 받았다면
            else if (i == time) {
                cur_health -= damage;
                j++;
                heal_cnt = 0;
                attacked = true;
                // 조기종료
                if (cur_health <= 0) {
                    flag = false;
                    break;
                }
            }
            
            
            // 1-1. 만약 공격 안받은 상태라면?
            if (!attacked) {
                // 만약 현재체력 < 풀체력
                if (cur_health < health) {
                    // 현재 체력 + 치료량 >= 풀피 일때?
                    if (cur_health + heal >= health) {
                        cur_health = health;
                    }
                    else if (cur_health + heal < health) cur_health += heal;
                }
            }
            
            // 1-2. 만약 치료횟수가 특정횟수 도달하면
            if (heal_cnt == cum_heal_cnt) {
                // 현재 체력 + 추가치료 >= 풀피 ---> 풀피 처리
                if (cur_health + additional_heal >= health) {
                    cur_health = health;
                }
                // 그게 아니라면 치료
                else if (cur_health + additional_heal < health) {
                    cur_health += additional_heal;
                }
                
                // 치료가 끝났으면 누적 치료횟수 초기화
                heal_cnt = 0;
            }         
            
            // 다음으로 전환
            i++;
        }
        
        if (!flag) {
            cur_health = -1;
        }
        
        return cur_health;
    }
}