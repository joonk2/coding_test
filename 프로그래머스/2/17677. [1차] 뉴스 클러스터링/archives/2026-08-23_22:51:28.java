import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        int N = str1.length();
        int M = str2.length();
        List<String> lst_1 = new ArrayList<>();
        List<String> lst_2 = new ArrayList<>();
        
        // 1. lst_1에 str1 원소 추가
        for (int i = 0; i < N-1; i++) {
            char ch_1 = Character.toLowerCase(str1.charAt(i));
            char ch_2 = Character.toLowerCase(str1.charAt(i+1));
            
            // 1-1. 만약 둘다 알파벳이면 lst_1에 추가
            if ( ('a' <= ch_1 && ch_1 <= 'z') && ('a' <= ch_2 && ch_2 <= 'z') ) {
                String temp = "";
                temp += ch_1;
                temp += ch_2;
                lst_1.add(temp);
            }
        }
        
        // 2. lst_2에 str2 추가
        for (int i = 0; i < M-1; i++) {
            char ch_1 = Character.toLowerCase(str2.charAt(i));
            char ch_2 = Character.toLowerCase(str2.charAt(i+1));
            
            // 2-1. 만약 둘다 알파벳이면 lst_2에 추가
            if ( ('a' <= ch_1 && ch_1 <= 'z') && ('a' <= ch_2 && ch_2 <= 'z') ) {
                String temp = "";
                temp += ch_1;
                temp += ch_2;
                lst_2.add(temp);
            }
        }
        
        
        int inner_join = 0;
        int outer_join = 0;
        
        // 3-1. inner_join 계산
        boolean[] visited = new boolean[lst_2.size()];
        for (int i = 0; i < lst_1.size(); i++) {
            String temp = lst_1.get(i);
            
            // 3-1-a. lst_2의 원소 썼는지 확인
            for (int j = 0; j < lst_2.size(); j++) {
                
                // 3-1-b. 원소를 썼다면 pass
                if (visited[j]) continue;
                
                // 3-1-c. 원소를 쓰지 않았고, lst_2가 lst_1의 원소를 갖고 있다면?
                if (lst_2.get(j).equals(temp)) {
                    inner_join++;
                    visited[j] = true;
                    break;
                }
            }
        }
        
        // 4. outer_join 계산
        outer_join = lst_1.size() + lst_2.size() - inner_join;
        
        // 5. 결과
        if (inner_join == 0 && outer_join == 0) {
            return 65536;
        }
        
        double res = (double) inner_join / outer_join;
        res *= 65536;
        answer = (int) res;
        return answer;
    }
}