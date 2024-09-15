# 생각해보자 기본 피보나치 수열 점화식 = dp[i] = dp[i-1] + dp[i-2]
# n은 40까지니 저장을 위해 최소 41칸 만들어주자

import sys
input = sys.stdin.readline
T = int(input())

for i in range(T):
    dp_0 = [0] * 41
    dp_1 = [0] * 41

    dp_0[0] = 1
    dp_1[1] = 1

    n = int(input())

    for i in range(2, n+1):
        dp_0[i] = dp_0[i-1] + dp_0[i-2]
        dp_1[i] = dp_1[i-1] + dp_1[i-2]

    print(dp_0[n], dp_1[n])