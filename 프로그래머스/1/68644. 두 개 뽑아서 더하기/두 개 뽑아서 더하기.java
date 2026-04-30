import java.util.HashSet;
import java.util.Set;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> hs = new HashSet<>();
        
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                hs.add(numbers[i] + numbers[j]);
            }
        }
        
        // 1. set -> lst
        List<Integer> lst = new ArrayList<>(hs);
        
        // 2. 정렬
        Collections.sort(lst);
        
        // 3. lst -> 배열
        
        int[] answer = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            answer[i] = lst.get(i);
        }
        
        
        return answer;
    }
}