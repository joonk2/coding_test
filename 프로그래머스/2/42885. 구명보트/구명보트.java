import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        
        int s = 0;
        int e = people.length-1;
        
        while (s <= e) {
            if (people[s] + people[e] > limit) {
                answer++;
                e--;
            }
            else if (people[s] + people[e] <= limit) {
                s++;
                e--;
                answer++;
            }
        }
        
        return answer;
    }
}