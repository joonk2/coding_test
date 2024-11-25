import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.HashSet;

public class Main {
        static class Team {
            String u, n; // 학교 이름, 팀 id
            int s, p; // solved, 패널티

            public Team(String u, String n, int s, int p) {
                this.u = u;
                this.n = n;
                this.s = s;
                this.p = p;
            }
        }

        static class TeamComparator implements Comparator<Team> {
            @Override
            public int compare(Team o1, Team o2) {
                if (o1.s != o2.s) {
                    return o2.s - o1.s; // 해결한 문제 수 내림차순
                }
                return o1.p - o2.p; // 패널티 오름차순
            }
        }


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            PriorityQueue<Team> pq = new PriorityQueue<>(new TeamComparator());

            // 팀 정보 입력
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String school = st.nextToken();
                String id = st.nextToken();
                int solved = Integer.parseInt(st.nextToken());
                int penalty = Integer.parseInt(st.nextToken());
                pq.offer(new Team(school, id, solved, penalty));
            }

            StringBuilder sb = new StringBuilder();
            HashSet<String> hs = new HashSet<>();

            // 결과 생성
            while (k > 0) {
                Team team = pq.poll();
                if (!hs.contains(team.u)) {
                    sb.append(team.n).append('\n');
                    hs.add(team.u);
                    k--;
                }
            }

            System.out.print(sb);



    }
}