# 피보나치 값 ex) 1000 이 너무 크면 메모리 초과다 ㅇㅋ?

import sys

input = sys.stdin.readline
n = int(input())

mod = 1000000
pisano_period = 1500000
n %= pisano_period

if n == 0:
    print(0)
else:
    dp = [0] * (n+1)
    dp[0] = 0
    dp[1] = 1

    for i in range(2, n+1):
        dp[i] = (dp[i-1] + dp[i-2]) % mod
    
    print(dp[n])
