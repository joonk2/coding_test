import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N,M,K;
    static long[] dmgList;
    static long[][] bossList;
    static long meso;
    static long[] mesoList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dmgList = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            dmgList[i] = Long.parseLong(st.nextToken());
        }

        bossList = new long[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine().trim());
            bossList[i][0] = Long.parseLong(st.nextToken());
            bossList[i][1] = Long.parseLong(st.nextToken());
        }

        mesoList = new long[N];
        for (int i = 0; i < N; i++) {
            meso = 0;
            subset(0, 15*60, 0, dmgList[i]);
            mesoList[i] = meso;
        }

        Arrays.sort(mesoList);

        long res = 0;
        for (int i = 1; i < M+1; i++) {
            res += mesoList[N-i];
        }

        System.out.println(res);



    }




    public static void subset(int idx, long remained_time, long cur_meso, long dmg) {
        if (idx == K) {
            meso = Math.max(meso, cur_meso);
            return;
        }

        long required_time = bossList[idx][0] / dmg;
        if (bossList[idx][0] % dmg > 0) {
            required_time++;
        }
        if (remained_time - required_time >= 0) {
            subset(idx+1, remained_time-required_time, cur_meso + bossList[idx][1], dmg);
        }
        subset(idx+1, remained_time, cur_meso, dmg);


    }




}